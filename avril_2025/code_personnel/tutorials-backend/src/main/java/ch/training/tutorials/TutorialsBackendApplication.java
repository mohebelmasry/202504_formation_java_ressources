package ch.training.tutorials;

import ch.training.tutorials.entity.CategoryEntity;
import ch.training.tutorials.entity.TutorialEntity;
import ch.training.tutorials.repository.CategoryRepository;
import ch.training.tutorials.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class TutorialsBackendApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final TutorialRepository tutorialRepository;

    public static void main(String[] args) {
        SpringApplication.run(TutorialsBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<CategoryEntity> categories = List.of(
                    CategoryEntity.builder().name("Développement Web").build(),
                    CategoryEntity.builder().name("Développement Mobile").build(),
                    CategoryEntity.builder().name("Développement Backend").build(),
                    CategoryEntity.builder().name("DevOps").build(),
                    CategoryEntity.builder().name("Intelligence Artificielle").build(),
                    CategoryEntity.builder().name("Data Science").build(),
                    CategoryEntity.builder().name("Big Data").build(),
                    CategoryEntity.builder().name("Sécurité Informatique").build(),
                    CategoryEntity.builder().name("Réseaux").build(),
                    CategoryEntity.builder().name("Systèmes et Virtualisation").build(),
                    CategoryEntity.builder().name("Cloud Computing").build(),
                    CategoryEntity.builder().name("Base de Données").build(),
                    CategoryEntity.builder().name("UX/UI Design").build(),
                    CategoryEntity.builder().name("Tests et Qualité Logicielle").build(),
                    CategoryEntity.builder().name("Gestion de Projet Agile").build(),
                    CategoryEntity.builder().name("Programmation (général)").build(),
                    CategoryEntity.builder().name("Machine Learning").build(),
                    CategoryEntity.builder().name("Blockchain").build(),
                    CategoryEntity.builder().name("Informatique Quantique").build()
            );

            // Sauvegarde toutes les catégories dans la base de données
            categoryRepository.saveAll(categories);
            System.out.println(">>> Catégories de formation informatique insérées !");
        } else {
            System.out.println(">>> Les catégories existent déjà, aucune insertion nécessaire.");
        }

        if (tutorialRepository.count() == 0) {
            List<TutorialEntity> tutorials = List.of(
                    TutorialEntity.builder()
                            .title("Introduction au Développement Web")
                            .description("Un tutoriel pour apprendre les bases du développement web.")
                            .content("Contenu détaillé sur HTML, CSS, et JavaScript.")
                            .creationDate(LocalDate.of(2023, 5, 10))  // Date différente
                            .build(),

                    TutorialEntity.builder()
                            .title("Prise en main de Spring Boot")
                            .description("Comment démarrer avec Spring Boot.")
                            .content("Explication sur la création d'une application Spring Boot, mise en place de REST API.")
                            .creationDate(LocalDate.of(2023, 6, 1))  // Date différente
                            .build(),

                    TutorialEntity.builder()
                            .title("Apprendre Python")
                            .description("Ce tutoriel va vous initier à la programmation avec Python.")
                            .content("Notions de base, structures de données, et bibliothèques populaires.")
                            .creationDate(LocalDate.of(2022, 11, 15))  // Date différente
                            .build(),

                    TutorialEntity.builder()
                            .title("Bases de données et SQL")
                            .description("Introduction aux bases de données relationnelles et à SQL.")
                            .content("Création de tables, requêtes SQL basiques et avancées.")
                            .creationDate(LocalDate.of(2022, 7, 22))  // Date différente
                            .build(),

                    TutorialEntity.builder()
                            .title("Introduction à l'Intelligence Artificielle")
                            .description("Apprenez les bases de l'IA et de l'apprentissage automatique.")
                            .content("Vue d'ensemble de l'apprentissage supervisé, non supervisé et du deep learning.")
                            .creationDate(LocalDate.of(2024, 3, 5))  // Date différente
                            .build()
            );

            // Sauvegarde les tutoriels dans la base de données
            tutorialRepository.saveAll(tutorials);
            System.out.println(">>> Tutoriels insérés avec succès !");
        } else {
            System.out.println(">>> Les tutoriels existent déjà, aucune insertion nécessaire.");
        }

    }
}
