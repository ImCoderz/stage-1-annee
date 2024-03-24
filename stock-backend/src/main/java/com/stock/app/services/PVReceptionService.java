package com.stock.app.services;

import com.stock.app.dtos.ProduitQuantite;
import com.stock.app.models.*;
import com.stock.app.repositories.PVReceptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class PVReceptionService {

    private final PVReceptionRepository pvReceptionRepository;
    private final CommandeFournisseurService commandeFournisseurService;
    private final CommandeProduitFournisseurService commandeProduitFournisseurService;
    private final FactureFournisseurService  factureFournisseurService;
    private final ProduitFiniService produitFiniService;

    private final ProduitPVReceptionService produitPVReceptionService;

    public Page<PVReception> getAllPVReceptions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return pvReceptionRepository.findAll(pageable);
    }

    public PVReception getPVReceptionById(Long id) {
        return pvReceptionRepository.findById(id).orElse(null);
    }

    public PVReception addPVReception(PVReception pvReception) {
        return pvReceptionRepository.save(pvReception);
    }
    public PVReception addPVReception(Long factureId , List<ProduitQuantite> produitQuantites) {
        PVReception pvReception=new PVReception();
        FactureFournisseur factureFournisseur=factureFournisseurService.getFactureFournisseurById(factureId);
        pvReception.setDateReception(LocalDate.now());
        pvReception.setFactureFournisseur(factureFournisseur);
        this.addPVReception(pvReception);
        List<CommandeProduitFournisseur> commandeProduitFournisseurs=commandeProduitFournisseurService.getCommandeProduitFournisseursByCommandeFournisseurId(factureFournisseur.getCommandeFournisseur().getId());
        HashMap<Long,Integer> produitIdQuantite =new HashMap<>();
        commandeProduitFournisseurs.forEach((cpf)->{
            produitIdQuantite.put(cpf.getProduitFini().getId(),cpf.getQuantite());
        });

        produitQuantites.forEach((pq)->{
            ProduitPVReception produitPVReception=new ProduitPVReception();

            produitPVReception.setProduitFini(produitFiniService.getProduitFiniById(pq.getProduitId()));
            produitPVReception.setPvReception(pvReception);
            produitPVReception.setQuantiteTheoriqueRecue(pq.getQuantite());
            produitPVReception.setQuantiteAvérée(produitIdQuantite.get(pq.getProduitId()));
            produitPVReception.setQuantiteManquante(produitPVReception.getQuantiteAvérée()-produitPVReception.getQuantiteTheoriqueRecue());
            produitPVReceptionService.addProduitPVReception(produitPVReception);
        });
        return pvReception;
    }

    public PVReception updatePVReception(PVReception pvReception) {
        return pvReceptionRepository.saveAndFlush(pvReception);
    }

    public void deletePVReceptionById(Long id) {
        pvReceptionRepository.deleteById(id);
    }
}
