package com.stock.app.services;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CodeBarresService {

    // Méthode pour générer un code-barres unique et enregistrer l'image
    public String generateAndSaveCodeBarres() throws IOException {
        // Générer une chaîne aléatoire pour le code-barres
        String randomString = RandomStringUtils.randomAlphanumeric(10);

        // Configuration de l'encodage du code-barres
        Map<EncodeHintType, BarcodeFormat> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, BarcodeFormat.CODE_128);

        try {
            // Création de la matrice de bits pour le code-barres
            BitMatrix bitMatrix = new MultiFormatWriter().encode(randomString, BarcodeFormat.CODE_128, 200, 50, hints);

            // Conversion de la matrice de bits en image de code-barres
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            String resourcesPath = "src/main/resources/static/";

            // Création du chemin de fichier pour enregistrer l'image dans le dossier des ressources statiques
            String filePath = resourcesPath + "codebarres.png";            // Enregistrement de l'image sur le disque
            File outputFile = new File(filePath);
            ImageIO.write(image, "png", outputFile);

            // Retourner la chaîne aléatoire comme code-barres
            return randomString;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
