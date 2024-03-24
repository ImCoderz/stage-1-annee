package com.stock.app;

import com.stock.app.exceptions.ClientNotFoundException;
import com.stock.app.models.*;
import com.stock.app.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientService clientService, FournisseurService fournisseurService, BoutiqueService boutiqueService, ProduitFiniService produitFiniService, CommandeClientService commandeClientService,CommandeProduitClientService commandeProduitClientService,FactureClientService factureClientService,ProduitFactureClientService produitFactureClientService,CommandeFournisseurService commandeFournisseurService,CommandeProduitFournisseurService commandeProduitFournisseurService,FactureFournisseurService factureFournisseurService,ProduitFactureFournisseurService produitFactureFournisseurService,ProduitPVReceptionService produitPVReceptionService,PVReceptionService pvReceptionService){
		return args->{
			Stream.of("MADINA","HAY","VILLE").forEach(u->{
				Boutique boutique=new Boutique();
				boutique.setAdresse(u+"rue 101");
				boutique.setNom(u);
				boutiqueService.addBoutique(boutique);
			});
			Stream.of("Ahmed","Said","Yassmine").forEach(u->{
				Client client=new Client();
				client.setNom(u);
				client.setAdresse(new Random().nextInt()<0.5?"Casablanca":"Rabat");
				client.setEmail(u+"@gmail.com");
				client.setPrenom("prenom"+u);
				client.setNumeroTelephone(new Random().nextInt()<0.5?"0671217120":"0778965754");
				clientService.addClient(client);
			});
			Stream.of("Omar","Meriem","Laila").forEach(u->{
				Fournisseur fournisseur=new Fournisseur();
				fournisseur.setNom(u);
				fournisseur.setAdresse(new Random().nextInt()<0.5?"Casablanca":"Rabat");
				fournisseur.setEmail(u+"@gmail.com");
				fournisseur.setNumeroTelephone(new Random().nextInt()<0.5?"0621212120":"0778986754");
				fournisseurService.addFournisseur(fournisseur);
			});
			Stream.of("Danone","Merendina","Lait").forEach((u)->{
				ProduitFini produitFini=new ProduitFini();
				Boutique boutique=boutiqueService.getBoutiqueById(1L);
				produitFini.setBoutique(boutique);
				produitFini.setCategorie(u);
				produitFini.setDescription(u+" description ...");
				produitFini.setIntitule(u);
				produitFini.setDateCreation(new Date());
				produitFini.setPrixUnitaire(new Random().nextInt()<0.5?10:20);
				produitFini.setQuantiteStock(new Random().nextInt()<0.5?30:70);
				produitFiniService.addProduitFini(produitFini);
			});

			Stream.of(1L,2L,3L).forEach((Id)->{
				Client client= null;
				try {
					client = clientService.getClientById(Id);
				} catch (ClientNotFoundException e) {
					throw new RuntimeException(e);
				}
				Boutique boutique=boutiqueService.getBoutiqueById(Id);
				if(client != null && boutique != null) {
					CommandeClient commandeClient=new CommandeClient();
					commandeClient.setBoutique(boutique);
					commandeClient.setClient(client);
					commandeClient.setDateCommande(LocalDate.now());
					commandeClientService.addCommandeClient(commandeClient);
					Stream.of(1L,2L,3L).forEach(p->{
						ProduitFini produitFini=produitFiniService.getProduitFiniById(p);
						CommandeProduitClient commandeProduitClient=new CommandeProduitClient();
						commandeProduitClient.setProduitFini(produitFini);
						commandeProduitClient.setQuantite((int)produitFini.getQuantiteStock()/(new Random().nextInt()<0.5?4:3));
						commandeProduitClient.setCommandeClient(commandeClient);
						commandeProduitClientService.addCommandeProduitClient(commandeProduitClient);
					});
				}
			});

			List<ProduitFactureClient> produitFactureClientList=new ArrayList<>();

			List<CommandeProduitClient> commandeProduitClientList=commandeProduitClientService.getCommandeProduitClientsByCommandeClientId(1L);
			 FactureClient factureClient=new FactureClient();
			 commandeProduitClientList.forEach((c)->{
				 ProduitFactureClient produitFactureClient=new ProduitFactureClient();
				 produitFactureClient.setFactureClient(factureClient);
				 produitFactureClient.setProduitFini(c.getProduitFini());
				 produitFactureClient.setQuantite(c.getQuantite());
				 factureClient.setPrixTotal(factureClient.getPrixTotal()+c.getQuantite()*c.getProduitFini().getPrixUnitaire());
				 produitFactureClientList.add(produitFactureClient);
			 });
			 factureClient.setDateFacture(LocalDate.now());
			 factureClient.setPaiement(true);
			 factureClient.setCommandeClient(commandeClientService.getCommandeClientById(1L));
			 factureClientService.addFactureClient(factureClient);
			 produitFactureClientList.stream().forEach((pfc)->{
				 produitFactureClientService.addProduitFactureClient(pfc);
			 });
			 produitFactureClientList.clear();


			List<CommandeProduitClient> commandeProduitClientList2=commandeProduitClientService.getCommandeProduitClientsByCommandeClientId(2L);
			FactureClient factureClient2=new FactureClient();
			commandeProduitClientList2.forEach((c)->{
				ProduitFactureClient produitFactureClient2=new ProduitFactureClient();
				produitFactureClient2.setFactureClient(factureClient2);

				produitFactureClient2.setProduitFini(c.getProduitFini());
				produitFactureClient2.setQuantite(c.getQuantite());
				factureClient2.setPrixTotal(factureClient2.getPrixTotal()+c.getQuantite()*c.getProduitFini().getPrixUnitaire());
				produitFactureClientList.add(produitFactureClient2);
			});
			factureClient2.setDateFacture(LocalDate.now());
			factureClient2.setPaiement(false);
			factureClient2.setCommandeClient(commandeClientService.getCommandeClientById(2L));
			factureClientService.addFactureClient(factureClient2);
			produitFactureClientList.stream().forEach((pfc)->{
				produitFactureClientService.addProduitFactureClient(pfc);
			});


			//FOURNISSEUR
			Stream.of(1L,2L,3L).forEach((Id)->{
				Fournisseur fournisseur=fournisseurService.getFournisseurById(Id);
				Boutique boutique=boutiqueService.getBoutiqueById(Id);
				if(fournisseur != null && boutique != null) {
					CommandeFournisseur commandeFournisseur=new CommandeFournisseur();
					commandeFournisseur.setBoutique(boutique);
					commandeFournisseur.setFournisseur(fournisseur);
					commandeFournisseur.setDateCommande(LocalDate.now());
					commandeFournisseurService.addCommandeFournisseur(commandeFournisseur);
					Stream.of(1L,2L,3L).forEach(p->{
						ProduitFini produitFini=produitFiniService.getProduitFiniById(p);
						CommandeProduitFournisseur commandeProduitFournisseur=new CommandeProduitFournisseur();
						commandeProduitFournisseur.setProduitFini(produitFini);
						commandeProduitFournisseur.setQuantite((int)produitFini.getQuantiteStock()/(new Random().nextInt()<0.5?4:3));
						commandeProduitFournisseur.setCommandeFournisseur(commandeFournisseur);
						commandeProduitFournisseurService.addCommandeProduitClient(commandeProduitFournisseur);
					});
				}
			});
			//facture fournisseur
			List<ProduitFactureFournisseur> produitFactureFournisseurList=new ArrayList<>();

			List<CommandeProduitFournisseur> commandeProduitFournisseurList=commandeProduitFournisseurService.getCommandeProduitFournisseursByCommandeFournisseurId(1L);
			FactureFournisseur factureFournisseur=new FactureFournisseur();
			commandeProduitFournisseurList.forEach((c)->{
				ProduitFactureFournisseur produitFactureFournisseur=new ProduitFactureFournisseur();
				produitFactureFournisseur.setFactureFournisseur(factureFournisseur);
				produitFactureFournisseur.setProduitFini(c.getProduitFini());
				produitFactureFournisseur.setQuantite(c.getQuantite());
				produitFactureFournisseur.setDateExpiration(LocalDate.now());
				produitFactureFournisseur.setDateFabrication(LocalDate.now());

				factureFournisseur.setPrixTotal(factureFournisseur.getPrixTotal()+c.getQuantite()*c.getProduitFini().getPrixUnitaire());
				produitFactureFournisseurList.add(produitFactureFournisseur);
			});
			factureFournisseur.setDateFacture(LocalDate.now());
			factureFournisseur.setCommandeFournisseur(commandeFournisseurService.getCommandeFournisseurById(1L));
			factureFournisseurService.addFactureFournisseur(factureFournisseur);
			produitFactureFournisseurList.stream().forEach((pfc)->{
				produitFactureFournisseurService.addProduitFactureFournisseur(pfc);
			});
			produitFactureClientList.clear();

			List<ProduitFactureFournisseur> produitFactureFournisseurList2=new ArrayList<>();

			List<CommandeProduitFournisseur> commandeProduitFournisseurList2=commandeProduitFournisseurService.getCommandeProduitFournisseursByCommandeFournisseurId(2L);
			FactureFournisseur factureFournisseur2=new FactureFournisseur();
			commandeProduitFournisseurList2.forEach((c)->{
				ProduitFactureFournisseur produitFactureFournisseur=new ProduitFactureFournisseur();
				produitFactureFournisseur.setFactureFournisseur(factureFournisseur2);
				produitFactureFournisseur.setProduitFini(c.getProduitFini());
				produitFactureFournisseur.setQuantite(c.getQuantite());
				produitFactureFournisseur.setDateExpiration(LocalDate.now());
				produitFactureFournisseur.setDateFabrication(LocalDate.now());
				factureFournisseur2.setPrixTotal(factureFournisseur2.getPrixTotal()+c.getQuantite()*c.getProduitFini().getPrixUnitaire());
				produitFactureFournisseurList2.add(produitFactureFournisseur);
			});
			factureFournisseur2.setDateFacture(LocalDate.now());
			factureFournisseur2.setCommandeFournisseur(commandeFournisseurService.getCommandeFournisseurById(2L));
			factureFournisseurService.addFactureFournisseur(factureFournisseur2);
			produitFactureFournisseurList2.stream().forEach((pfc)->{
				produitFactureFournisseurService.addProduitFactureFournisseur(pfc);
			});
			produitFactureClientList.clear();


			//PVreception
			PVReception pvReception=new PVReception();
			FactureFournisseur factureFournisseur3=factureFournisseurService.getFactureFournisseurById(1L);
			pvReception.setDateReception(LocalDate.now());
			pvReception.setFactureFournisseur(factureFournisseur3);
			pvReceptionService.addPVReception(pvReception);
			List<CommandeProduitFournisseur> commandeProduitFournisseurs=commandeProduitFournisseurService.getCommandeProduitFournisseursByCommandeFournisseurId(factureFournisseur3.getCommandeFournisseur().getId());
			commandeProduitFournisseurs.forEach((cpc)->{
				ProduitPVReception produitPVReception=new ProduitPVReception();
				produitPVReception.setProduitFini(cpc.getProduitFini());
				produitPVReception.setPvReception(pvReception);
				produitPVReception.setQuantiteTheoriqueRecue(cpc.getQuantite()-(new Random().nextInt(4)+3));
				produitPVReception.setQuantiteAvérée(cpc.getQuantite());
				produitPVReception.setQuantiteManquante(produitPVReception.getQuantiteAvérée()-produitPVReception.getQuantiteTheoriqueRecue());
				produitPVReceptionService.addProduitPVReception(produitPVReception);
			});

			PVReception pvReception2=new PVReception();
			FactureFournisseur factureFournisseur4=factureFournisseurService.getFactureFournisseurById(2L);
			pvReception2.setDateReception(LocalDate.now());
			pvReception2.setFactureFournisseur(factureFournisseur4);
			pvReceptionService.addPVReception(pvReception2);
			List<CommandeProduitFournisseur> commandeProduitFournisseurs2=commandeProduitFournisseurService.getCommandeProduitFournisseursByCommandeFournisseurId(factureFournisseur4.getCommandeFournisseur().getId());
			commandeProduitFournisseurs2.forEach((cpc)->{
				ProduitPVReception produitPVReception=new ProduitPVReception();
				produitPVReception.setProduitFini(cpc.getProduitFini());
				produitPVReception.setPvReception(pvReception2);
				produitPVReception.setQuantiteTheoriqueRecue(cpc.getQuantite()-(new Random().nextInt(4)+3));
				produitPVReception.setQuantiteAvérée(cpc.getQuantite());
				produitPVReception.setQuantiteManquante(produitPVReception.getQuantiteAvérée()-produitPVReception.getQuantiteTheoriqueRecue());
				produitPVReceptionService.addProduitPVReception(produitPVReception);
			});
		};
	}


}
