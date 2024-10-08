INSERT INTO hospital (hospital_id, hospital_name , hospital_latitude , hospital_longitude) VALUES
(1, 'National Hospital for Neurology and Neurosurgery', 51.522233, -0.122362),
(2, 'Priory Hospital', 51.632064, -0.118304),
(3, 'Bridge Lane Health Centre', 51.473268, -0.166317),
(4, 'British Home & Hospital for Incurables', 51.423089, -0.107068),
(5, 'Chelsfield Park Hospital', 51.358257, 0.131675),
(6, 'Sloane Hospital', 51.408204, -0.004540),
(7, 'Queen Mary''s Childrens'' Hospital', 51.379798, -0.184842),
(8, 'Chapel Orchard Day Surgery', 51.402049, -0.171537),
(9, 'UCL Institute of Orthopaedics and Musculoskeletal Science', 51.631243, -0.307443),
(10, 'The Portland Hospital for Women and Children', 51.522471, -0.143586),
(11, 'North London Hospice Winchmore Hill', 51.624991, -0.092509);

INSERT INTO speciality_group (speciality_group_id, speciality_group_name) VALUES
(12, 'Anesthésie'),
(13, 'Oncologie clinique'),
(14, 'Groupe dentaire'),
(15, 'Médecine d''urgence'),
(16, 'Groupe de médecine générale'),
(17, 'Obstétrique et gynécologie'),
(18, 'Groupe pédiatrique'),
(19, 'Groupe de psychiatrie'),
(20, 'Groupe de radiologie'),
(21, 'Groupe chirurgical');

INSERT INTO speciality (speciality_id, speciality_name, speciality_group_id) VALUES
(22, 'Anesthésie', 12),
(23, 'Soins intensifs', 12),
(24, 'Oncologie clinique', 13),
(25, 'Spécialités dentaires supplémentaires', 14),
(26, 'Radiologie dentaire et maxillo-faciale', 14),
(27, 'Endodontie', 14),
(28, 'Chirurgie buccale et maxillo-faciale', 14),
(29, 'Pathologie buccale et maxillo-faciale', 14),
(30, 'Médecine buccale', 14),
(31, 'Chirurgie buccale', 14),
(32, 'Orthodontie', 14),
(33, 'Dentisterie pédiatrique', 14),
(34, 'Parodontie', 14),
(35, 'Prosthodontie', 14),
(36, 'Dentisterie restauratrice', 14),
(37, 'Dentisterie de soins spéciaux', 14),
(38, 'Médecine d''urgence', 15),
(39, 'Médecine interne de soins aigus', 16),
(40, 'Allergie', 16),
(41, 'Médecine audiovestibulaire', 16),
(42, 'Cardiologie', 16),
(43, 'Génétique clinique', 16),
(44, 'Neurophysiologie clinique', 16),
(45, 'Pharmacologie clinique et thérapeutique', 16),
(46, 'Dermatologie', 16),
(47, 'Endocrinologie et diabète sucré', 16),
(48, 'Gastroentérologie', 16),
(49, 'Médecine générale (interne)', 16),
(50, 'Médecine générale', 16),
(51, 'Médecine générale (GP) 6 mois', 16),
(52, 'Médecine génito-urinaire', 16),
(53, 'Médecine gériatrique', 16),
(54, 'Maladies infectieuses', 16),
(55, 'Oncologie médicale', 16),
(56, 'Ophtalmologie médicale', 16),
(57, 'Neurologie', 16),
(58, 'Médecine du travail', 16),
(59, 'Autre', 16),
(60, 'Médecine palliative', 16),
(61, 'Médecine de réadaptation', 16),
(62, 'Médecine rénale', 16),
(63, 'Médecine respiratoire', 16),
(64, 'Rhumatologie', 16),
(65, 'Médecine du sport et de l''exercice', 16),
(66, 'Santé publique sexuelle et procréative', 17),
(67, 'Cardiologie pédiatrique', 18),
(68, 'Pédiatrie', 18),
(69, 'Psychiatrie de la vieillesse', 19),
(70, 'Psychiatrie des troubles d''apprentissage', 19),
(71, 'Psychothérapie', 19),
(72, 'Radiologie clinique', 20),
(73, 'Médecine nucléaire', 20),
(74, 'Chirurgie cardiothoracique', 21),
(75, 'Chirurgie générale', 21),
(76, 'Neurochirurgie', 21),
(77, 'Ophtalmologie', 21),
(78, 'Otolaryngologie', 21),
(79, 'Chirurgie pédiatrique', 21),
(80, 'Chirurgie plastique', 21),
(81, 'Traumatologie et chirurgie orthopédique', 21),
(82, 'Urologie', 21),
(83, 'Chirurgie vasculaire', 21);

INSERT INTO hospital_specialities (hospital_id, speciality_id) VALUES
(1, 22), (1, 23), (1, 24), (1, 25), (1, 26), (1, 27), (1, 28), (1, 29), (1, 30), (1, 31), (1, 32), (1, 33),
(1, 34), (1, 35), (1, 36), (1, 37), (1, 38), (1, 39), (1, 40), (1, 41), (1, 42), (1, 43), (1, 44), (1, 45),
(1, 46), (1, 47), (1, 48), (1, 49), (1, 50), (1, 51), (1, 52), (1, 53), (1, 54), (1, 55), (1, 56), (1, 57),
(1, 58), (1, 59), (1, 60), (1, 61), (1, 62), (1, 63), (1, 64), (1, 65), (1, 66), (1, 67), (1, 68), (1, 69),
(1, 70), (1, 71), (1, 72), (1, 73), (1, 74), (1, 75), (1, 76), (1, 77), (1, 78), (1, 79), (1, 80), (1, 81),
(1, 82), (1, 83),
(2, 22), (2, 23), (2, 24), (2, 25), (2, 26), (2, 27), (2, 28), (2, 29), (2, 30), (2, 31), (2, 32), (2, 33),
(2, 34), (2, 35), (2, 36), (2, 37), (2, 38), (2, 39), (2, 40), (2, 41), (2, 42), (2, 43), (2, 44), (2, 45),
(2, 46), (2, 47), (2, 48), (2, 49), (2, 50), (2, 51), (2, 52), (2, 53), (2, 54), (2, 55), (2, 56), (2, 57),
(2, 58), (2, 59), (2, 60), (2, 61), (2, 62), (2, 63), (2, 64), (2, 65), (2, 66), (2, 67), (2, 68), (2, 69),
(2, 70), (2, 71), (2, 72), (2, 73), (2, 74), (2, 75), (2, 76), (2, 77), (2, 78), (2, 79), (2, 80), (2, 81),
(2, 82), (2, 83),
(3, 22), (3, 23), (3, 24), (3, 25), (3, 26), (3, 27), (3, 28), (3, 29), (3, 30), (3, 31), (3, 32), (3, 33),
(3, 34), (3, 35), (3, 36), (3, 37), (3, 38), (3, 39), (3, 40), (3, 41), (3, 42), (3, 43), (3, 44), (3, 45),
(3, 46), (3, 47), (3, 48), (3, 49), (3, 50), (3, 51), (3, 52), (3, 53), (3, 54), (3, 55), (3, 56), (3, 57),
(3, 58), (3, 59), (3, 60), (3, 61), (3, 62), (3, 63), (3, 64), (3, 65), (3, 66), (3, 67), (3, 68), (3, 69),
(3, 70), (3, 71), (3, 72), (3, 73), (3, 74), (3, 75), (3, 76), (3, 77), (3, 78), (3, 79), (3, 80), (3, 81),
(3, 82), (3, 83),
(4, 22), (4, 23), (4, 24), (4, 25), (4, 26), (4, 27), (4, 28), (4, 29), (4, 30), (4, 31), (4, 32), (4, 33),
(4, 34), (4, 35), (4, 36), (4, 37), (4, 38), (4, 39), (4, 40), (4, 41), (4, 42), (4, 43), (4, 44), (4, 45),
(4, 46), (4, 47), (4, 48), (4, 49), (4, 50), (4, 51), (4, 52), (4, 53), (4, 54), (4, 55), (4, 56), (4, 57),
(4, 58), (4, 59), (4, 60), (4, 61), (4, 62), (4, 63), (4, 64), (4, 65), (4, 66), (4, 67), (4, 68), (4, 69),
(4, 70), (4, 71), (4, 72), (4, 73), (4, 74), (4, 75), (4, 76), (4, 77), (4, 78), (4, 79), (4, 80), (4, 81),
(4, 82), (4, 83),
(5, 22), (5, 23), (5, 24), (5, 25), (5, 26), (5, 27), (5, 28), (5, 29), (5, 30), (5, 31), (5, 32), (5, 33),
(5, 34), (5, 35), (5, 36), (5, 37), (5, 38), (5, 39), (5, 40), (5, 41), (5, 42), (5, 43), (5, 44), (5, 45), (5, 46), (5, 47), (5, 48), (5, 49), (5, 50), (5, 51), (5, 52), (5, 53), (5, 54), (5, 55), (5, 56), (5, 57), (5, 58), (5, 59), (5, 60), (5, 61),
(5, 62), (5, 63), (5, 64), (5, 65), (5, 66), (5, 67), (5, 68), (5, 69), (5, 70), (5, 71), (5, 72), (5, 73),
(5, 74), (5, 75), (5, 76), (5, 77), (5, 78), (5, 79), (5, 80), (5, 81), (5, 82), (5, 83),
(6, 22), (6, 23), (6, 24), (6, 25), (6, 26), (6, 27), (6, 28), (6, 29), (6, 30), (6, 31), (6, 32), (6, 33),
(6, 34), (6, 35), (6, 36), (6, 37), (6, 38), (6, 39), (6, 40), (6, 41), (6, 42), (6, 43), (6, 44), (6, 45),
(6, 46), (6, 47), (6, 48), (6, 49), (6, 50), (6, 51), (6, 52), (6, 53), (6, 54), (6, 55), (6, 56), (6, 57),
(6, 58), (6, 59), (6, 60), (6, 61), (6, 62), (6, 63), (6, 64), (6, 65), (6, 66), (6, 67), (6, 68), (6, 69),
(6, 70), (6, 71), (6, 72), (6, 73), (6, 74), (6, 75), (6, 76), (6, 77), (6, 78), (6, 79), (6, 80), (6, 81),
(6, 82), (6, 83),
(7, 22), (7, 23), (7, 24), (7, 25), (7, 26), (7, 27), (7, 28), (7, 29), (7, 30), (7, 31), (7, 32), (7, 33),
(7, 34), (7, 35), (7, 36), (7, 37), (7, 38), (7, 39), (7, 40), (7, 41), (7, 42), (7, 43), (7, 44), (7, 45),
(7, 46), (7, 47), (7, 48), (7, 49), (7, 50), (7, 51), (7, 52), (7, 53), (7, 54), (7, 55), (7, 56), (7, 57),
(7, 58), (7, 59), (7, 60), (7, 61), (7, 62), (7, 63), (7, 64), (7, 65), (7, 66), (7, 67), (7, 68), (7, 69),
(7, 70), (7, 71), (7, 72), (7, 73), (7, 74), (7, 75), (7, 76), (7, 77), (7, 78), (7, 79), (7, 80), (7, 81),
(7, 82), (7, 83),
(8, 22), (8, 23), (8, 24), (8, 25), (8, 26), (8, 27), (8, 28), (8, 29), (8, 30), (8, 31), (8, 32), (8, 33),
(8, 34), (8, 35), (8, 36), (8, 37), (8, 38), (8, 39), (8, 40), (8, 41), (8, 42), (8, 43), (8, 44), (8, 45),
(8, 46), (8, 47), (8, 48), (8, 49), (8, 50), (8, 51), (8, 52), (8, 53), (8, 54), (8, 55), (8, 56), (8, 57),
(8, 58), (8, 59), (8, 60), (8, 61), (8, 62), (8, 63), (8, 64), (8, 65), (8, 66), (8, 67), (8, 68), (8, 69),
(8, 70), (8, 71), (8, 72), (8, 73), (8, 74), (8, 75), (8, 76), (8, 77), (8, 78), (8, 79), (8, 80), (8, 81),
(8, 82), (8, 83),
(9, 22), (9, 23), (9, 24), (9, 25), (9, 26), (9, 27), (9, 28), (9, 29), (9, 30), (9, 31), (9, 32), (9, 33),
(9, 34), (9, 35), (9, 36), (9, 37), (9, 38), (9, 39), (9, 40), (9, 41), (9, 42), (9, 43), (9, 44), (9, 45),
(9, 46), (9, 47), (9, 48), (9, 49), (9, 50), (9, 51), (9, 52), (9, 53), (9, 54), (9, 55), (9, 56), (9, 57),
(9, 58), (9, 59), (9, 60), (9, 61), (9, 62), (9, 63), (9, 64), (9, 65), (9, 66), (9, 67), (9, 68), (9, 69),
(9, 70), (9, 71), (9, 72), (9, 73), (9, 74), (9, 75), (9, 76), (9, 77), (9, 78), (9, 79), (9, 80), (9, 81),
(9, 82), (9, 83),
(10, 22), (10, 23), (10, 24), (10, 25), (10, 26), (10, 27), (10, 28), (10, 29), (10, 30), (10, 31), (10, 32), (10, 33),
(10, 34), (10, 35), (10, 36), (10, 37), (10, 38), (10, 39), (10, 40), (10, 41), (10, 42), (10, 43), (10, 44), (10, 45),
(10, 46), (10, 47), (10, 48), (10, 49), (10, 50), (10, 51), (10, 52), (10, 53), (10, 54), (10, 55), (10, 56), (10, 57),
(10, 58), (10, 59), (10, 60), (10, 61), (10, 62), (10, 63), (10, 64), (10, 65), (10, 66), (10, 67), (10, 68), (10, 69),
(10, 70), (10, 71), (10, 72), (10, 73), (10, 74), (10, 75), (10, 76), (10, 77), (10, 78), (10, 79), (10, 80), (10, 81),
(10, 82), (10, 83),
(11, 22), (11, 23), (11, 24), (11, 25), (11, 26), (11, 27), (11, 28), (11, 29), (11, 30), (11, 31), (11, 32), (11, 33),
(11, 34), (11, 35), (11, 36), (11, 37), (11, 38), (11, 39), (11, 40), (11, 41), (11, 42), (11, 43), (11, 44), (11, 45),
(11, 46), (11, 47), (11, 48), (11, 49), (11, 50), (11, 51), (11, 52), (11, 53), (11, 54), (11, 55), (11, 56), (11, 57),
(11, 58), (11, 59), (11, 60), (11, 61), (11, 62), (11, 63), (11, 64), (11, 65), (11, 66), (11, 67), (11, 68), (11, 69),
(11, 70), (11, 71), (11, 72), (11, 73), (11, 74), (11, 75), (11, 76), (11, 77), (11, 78), (11, 79), (11, 80), (11, 81),
(11, 82), (11, 83);

INSERT INTO bed (hospital_id, speciality_id, bed_code, is_free) VALUES
(1, 22, '1-22-B01', TRUE),(1, 23, '1-23-B01', TRUE),(1, 24, '1-24-B01', TRUE),(1, 25, '1-25-B01', TRUE),
(1, 26, '1-26-B01', TRUE),(1, 27, '1-27-B01', TRUE),(1, 28, '1-28-B01', TRUE),(1, 29, '1-29-B01', TRUE),
(1, 30, '1-30-B01', TRUE),(1, 31, '1-31-B01', TRUE),(1, 32, '1-32-B01', TRUE),(1, 33, '1-33-B01', TRUE),
(1, 34, '1-34-B01', TRUE),(1, 35, '1-35-B01', TRUE),(1, 36, '1-36-B01', TRUE),(1, 37, '1-37-B01', TRUE),
(1, 38, '1-38-B01', TRUE),(1, 39, '1-39-B01', TRUE),(1, 40, '1-40-B01', TRUE),(1, 41, '1-41-B01', TRUE),
(1, 42, '1-42-B01', TRUE),(1, 43, '1-43-B01', TRUE),(1, 44, '1-44-B01', TRUE),(1, 45, '1-45-B01', TRUE),
(1, 46, '1-46-B01', TRUE),(1, 47, '1-47-B01', TRUE),(1, 48, '1-48-B01', TRUE),(1, 49, '1-49-B01', TRUE),
(1, 50, '1-50-B01', TRUE),(1, 51, '1-51-B01', TRUE),(1, 52, '1-52-B01', TRUE),(1, 53, '1-53-B01', TRUE),
(1, 54, '1-54-B01', TRUE),(1, 55, '1-55-B01', TRUE),(1, 56, '1-56-B01', TRUE),(1, 57, '1-57-B01', TRUE),
(1, 58, '1-58-B01', TRUE),(1, 59, '1-59-B01', TRUE),(1, 60, '1-60-B01', TRUE),(1, 61, '1-61-B01', TRUE),
(1, 62, '1-62-B01', TRUE),(1, 63, '1-63-B01', TRUE),(1, 64, '1-64-B01', TRUE),(1, 65, '1-65-B01', TRUE),
(1, 66, '1-66-B01', TRUE),(1, 67, '1-67-B01', TRUE),(1, 68, '1-68-B01', TRUE),(1, 69, '1-69-B01', TRUE),
(1, 70, '1-70-B01', TRUE),(1, 71, '1-71-B01', TRUE),(1, 72, '1-72-B01', TRUE),(1, 73, '1-73-B01', TRUE),
(1, 74, '1-74-B01', TRUE),(1, 75, '1-75-B01', TRUE),(1, 76, '1-76-B01', TRUE),(1, 77, '1-77-B01', TRUE),
(1, 78, '1-78-B01', TRUE),(1, 79, '1-79-B01', TRUE),(1, 80, '1-80-B01', TRUE),(1, 81, '1-81-B01', TRUE),
(1, 82, '1-82-B01', TRUE),(1, 83, '1-83-B01', TRUE),
(2, 22, '2-22-B01', TRUE),(2, 23, '2-23-B01', TRUE),(2, 24, '2-24-B01', TRUE),(2, 25, '2-25-B01', TRUE),
(2, 26, '2-26-B01', TRUE),(2, 27, '2-27-B01', TRUE),(2, 28, '2-28-B01', TRUE),(2, 29, '2-29-B01', TRUE),
(2, 30, '2-30-B01', TRUE),(2, 31, '2-31-B01', TRUE),(2, 32, '2-32-B01', TRUE),(2, 33, '2-33-B01', TRUE),
(2, 34, '2-34-B01', TRUE),(2, 35, '2-35-B01', TRUE),(2, 36, '2-36-B01', TRUE),(2, 37, '2-37-B01', TRUE),
(2, 38, '2-38-B01', TRUE),(2, 39, '2-39-B01', TRUE),(2, 40, '2-40-B01', TRUE),(2, 41, '2-41-B01', TRUE),
(2, 42, '2-42-B01', TRUE),(2, 43, '2-43-B01', TRUE),(2, 44, '2-44-B01', TRUE),(2, 45, '2-45-B01', TRUE),
(2, 46, '2-46-B01', TRUE),(2, 47, '2-47-B01', TRUE),(2, 48, '2-48-B01', TRUE),(2, 49, '2-49-B01', TRUE),
(2, 50, '2-50-B01', TRUE),(2, 51, '2-51-B01', TRUE),(2, 52, '2-52-B01', TRUE),(2, 53, '2-53-B01', TRUE),
(2, 54, '2-54-B01', TRUE),(2, 55, '2-55-B01', TRUE),(2, 56, '2-56-B01', TRUE),(2, 57, '2-57-B01', TRUE),
(2, 58, '2-58-B01', TRUE),(2, 59, '2-59-B01', TRUE),(2, 60, '2-60-B01', TRUE),(2, 61, '2-61-B01', TRUE),
(2, 62, '2-62-B01', TRUE),(2, 63, '2-63-B01', TRUE),(2, 64, '2-64-B01', TRUE),(2, 65, '2-65-B01', TRUE),
(2, 66, '2-66-B01', TRUE),(2, 67, '2-67-B01', TRUE),(2, 68, '2-68-B01', TRUE),(2, 69, '2-69-B01', TRUE),
(2, 70, '2-70-B01', TRUE),(2, 71, '2-71-B01', TRUE),(2, 72, '2-72-B01', TRUE),(2, 73, '2-73-B01', TRUE),
(2, 74, '2-74-B01', TRUE),(2, 75, '2-75-B01', TRUE),(2, 76, '2-76-B01', TRUE),(2, 77, '2-77-B01', TRUE),
(2, 78, '2-78-B01', TRUE),(2, 79, '2-79-B01', TRUE),(2, 80, '2-80-B01', TRUE),(2, 81, '2-81-B01', TRUE),
(2, 82, '2-82-B01', TRUE),(2, 83, '2-83-B01', TRUE),
(3, 22, '3-22-B01', TRUE), (3, 23, '3-23-B01', TRUE), (3, 24, '3-24-B01', TRUE), (3, 25, '3-25-B01', TRUE),
(3, 26, '3-26-B01', TRUE), (3, 27, '3-27-B01', TRUE), (3, 28, '3-28-B01', TRUE), (3, 29, '3-29-B01', TRUE),
(3, 30, '3-30-B01', TRUE), (3, 31, '3-31-B01', TRUE), (3, 32, '3-32-B01', TRUE), (3, 33, '3-33-B01', TRUE),
(3, 34, '3-34-B01', TRUE), (3, 35, '3-35-B01', TRUE), (3, 36, '3-36-B01', TRUE), (3, 37, '3-37-B01', TRUE),
(3, 38, '3-38-B01', TRUE), (3, 39, '3-39-B01', TRUE), (3, 40, '3-40-B01', TRUE), (3, 41, '3-41-B01', TRUE),
(3, 42, '3-42-B01', TRUE), (3, 43, '3-43-B01', TRUE), (3, 44, '3-44-B01', TRUE), (3, 45, '3-45-B01', TRUE),
(3, 46, '3-46-B01', TRUE), (3, 47, '3-47-B01', TRUE), (3, 48, '3-48-B01', TRUE), (3, 49, '3-49-B01', TRUE),
(3, 50, '3-50-B01', TRUE), (3, 51, '3-51-B01', TRUE), (3, 52, '3-52-B01', TRUE), (3, 53, '3-53-B01', TRUE),
(3, 54, '3-54-B01', TRUE), (3, 55, '3-55-B01', TRUE), (3, 56, '3-56-B01', TRUE), (3, 57, '3-57-B01', TRUE),
(3, 58, '3-58-B01', TRUE), (3, 59, '3-59-B01', TRUE), (3, 60, '3-60-B01', TRUE), (3, 61, '3-61-B01', TRUE),
(3, 62, '3-62-B01', TRUE), (3, 63, '3-63-B01', TRUE), (3, 64, '3-64-B01', TRUE), (3, 65, '3-65-B01', TRUE),
(3, 66, '3-66-B01', TRUE), (3, 67, '3-67-B01', TRUE), (3, 68, '3-68-B01', TRUE), (3, 69, '3-69-B01', TRUE),
(3, 70, '3-70-B01', TRUE), (3, 71, '3-71-B01', TRUE), (3, 72, '3-72-B01', TRUE), (3, 73, '3-73-B01', TRUE),
(3, 74, '3-74-B01', TRUE), (3, 75, '3-75-B01', TRUE), (3, 76, '3-76-B01', TRUE), (3, 77, '3-77-B01', TRUE),
(3, 78, '3-78-B01', TRUE), (3, 79, '3-79-B01', TRUE), (3, 80, '3-80-B01', TRUE), (3, 81, '3-81-B01', TRUE),
(3, 82, '3-82-B01', TRUE), (3, 83, '3-83-B01', TRUE),
(4, 22, '4-22-B01', TRUE), (4, 23, '4-23-B01', TRUE), (4, 24, '4-24-B01', TRUE), (4, 25, '4-25-B01', TRUE),
(4, 26, '4-26-B01', TRUE), (4, 27, '4-27-B01', TRUE), (4, 28, '4-28-B01', TRUE), (4, 29, '4-29-B01', TRUE),
(4, 30, '4-30-B01', TRUE), (4, 31, '4-31-B01', TRUE), (4, 32, '4-32-B01', TRUE), (4, 33, '4-33-B01', TRUE),
(4, 34, '4-34-B01', TRUE), (4, 35, '4-35-B01', TRUE), (4, 36, '4-36-B01', TRUE), (4, 37, '4-37-B01', TRUE),
(4, 38, '4-38-B01', TRUE), (4, 39, '4-39-B01', TRUE), (4, 40, '4-40-B01', TRUE), (4, 41, '4-41-B01', TRUE),
(4, 42, '4-42-B01', TRUE), (4, 43, '4-43-B01', TRUE), (4, 44, '4-44-B01', TRUE), (4, 45, '4-45-B01', TRUE),
(4, 46, '4-46-B01', TRUE), (4, 47, '4-47-B01', TRUE), (4, 48, '4-48-B01', TRUE), (4, 49, '4-49-B01', TRUE),
(4, 50, '4-50-B01', TRUE), (4, 51, '4-51-B01', TRUE), (4, 52, '4-52-B01', TRUE), (4, 53, '4-53-B01', TRUE),
(4, 54, '4-54-B01', TRUE), (4, 55, '4-55-B01', TRUE), (4, 56, '4-56-B01', TRUE), (4, 57, '4-57-B01', TRUE),
(4, 58, '4-58-B01', TRUE), (4, 59, '4-59-B01', TRUE), (4, 60, '4-60-B01', TRUE), (4, 61, '4-61-B01', TRUE),
(4, 62, '4-62-B01', TRUE), (4, 63, '4-63-B01', TRUE), (4, 64, '4-64-B01', TRUE), (4, 65, '4-65-B01', TRUE),
(4, 66, '4-66-B01', TRUE), (4, 67, '4-67-B01', TRUE), (4, 68, '4-68-B01', TRUE), (4, 69, '4-69-B01', TRUE),
(4, 70, '4-70-B01', TRUE), (4, 71, '4-71-B01', TRUE), (4, 72, '4-72-B01', TRUE), (4, 73, '4-73-B01', TRUE),
(4, 74, '4-74-B01', TRUE), (4, 75, '4-75-B01', TRUE), (4, 76, '4-76-B01', TRUE), (4, 77, '4-77-B01', TRUE),
(4, 78, '4-78-B01', TRUE), (4, 79, '4-79-B01', TRUE), (4, 80, '4-80-B01', TRUE), (4, 81, '4-81-B01', TRUE),
(4, 82, '4-82-B01', TRUE), (4, 83, '4-83-B01', TRUE),
(5, 22, '5-22-B01', TRUE), (5, 23, '5-23-B01', TRUE), (5, 24, '5-24-B01', TRUE), (5, 25, '5-25-B01', TRUE),
(5, 26, '5-26-B01', TRUE), (5, 27, '5-27-B01', TRUE), (5, 28, '5-28-B01', TRUE), (5, 29, '5-29-B01', TRUE),
(5, 30, '5-30-B01', TRUE), (5, 31, '5-31-B01', TRUE), (5, 32, '5-32-B01', TRUE), (5, 33, '5-33-B01', TRUE),
(5, 34, '5-34-B01', TRUE), (5, 35, '5-35-B01', TRUE), (5, 36, '5-36-B01', TRUE), (5, 37, '5-37-B01', TRUE),
(5, 38, '5-38-B01', TRUE), (5, 39, '5-39-B01', TRUE), (5, 40, '5-40-B01', TRUE), (5, 41, '5-41-B01', TRUE),
(5, 42, '5-42-B01', TRUE), (5, 43, '5-43-B01', TRUE), (5, 44, '5-44-B01', TRUE), (5, 45, '5-45-B01', TRUE),
(5, 46, '5-46-B01', TRUE), (5, 47, '5-47-B01', TRUE), (5, 48, '5-48-B01', TRUE), (5, 49, '5-49-B01', TRUE),
(5, 50, '5-50-B01', TRUE), (5, 51, '5-51-B01', TRUE), (5, 52, '5-52-B01', TRUE), (5, 53, '5-53-B01', TRUE),
(5, 54, '5-54-B01', TRUE), (5, 55, '5-55-B01', TRUE), (5, 56, '5-56-B01', TRUE), (5, 57, '5-57-B01', TRUE),
(5, 58, '5-58-B01', TRUE), (5, 59, '5-59-B01', TRUE), (5, 60, '5-60-B01', TRUE), (5, 61, '5-61-B01', TRUE),
(5, 62, '5-62-B01', TRUE), (5, 63, '5-63-B01', TRUE), (5, 64, '5-64-B01', TRUE), (5, 65, '5-65-B01', TRUE),
(5, 66, '5-66-B01', TRUE), (5, 67, '5-67-B01', TRUE), (5, 68, '5-68-B01', TRUE), (5, 69, '5-69-B01', TRUE),
(5, 70, '5-70-B01', TRUE), (5, 71, '5-71-B01', TRUE), (5, 72, '5-72-B01', TRUE), (5, 73, '5-73-B01', TRUE),
(5, 74, '5-74-B01', TRUE), (5, 75, '5-75-B01', TRUE), (5, 76, '5-76-B01', TRUE), (5, 77, '5-77-B01', TRUE),
(5, 78, '5-78-B01', TRUE), (5, 79, '5-79-B01', TRUE), (5, 80, '5-80-B01', TRUE), (5, 81, '5-81-B01', TRUE),
(5, 82, '5-82-B01', TRUE), (5, 83, '5-83-B01', TRUE),
(6, 22, '6-22-B01', TRUE), (6, 23, '6-23-B01', TRUE), (6, 24, '6-24-B01', TRUE), (6, 25, '6-25-B01', TRUE),
(6, 26, '6-26-B01', TRUE), (6, 27, '6-27-B01', TRUE), (6, 28, '6-28-B01', TRUE), (6, 29, '6-29-B01', TRUE),
(6, 30, '6-30-B01', TRUE), (6, 31, '6-31-B01', TRUE), (6, 32, '6-32-B01', TRUE), (6, 33, '6-33-B01', TRUE),
(6, 34, '6-34-B01', TRUE), (6, 35, '6-35-B01', TRUE), (6, 36, '6-36-B01', TRUE), (6, 37, '6-37-B01', TRUE),
(6, 38, '6-38-B01', TRUE), (6, 39, '6-39-B01', TRUE), (6, 40, '6-40-B01', TRUE), (6, 41, '6-41-B01', TRUE),
(6, 42, '6-42-B01', TRUE), (6, 43, '6-43-B01', TRUE), (6, 44, '6-44-B01', TRUE), (6, 45, '6-45-B01', TRUE),
(6, 46, '6-46-B01', TRUE), (6, 47, '6-47-B01', TRUE), (6, 48, '6-48-B01', TRUE), (6, 49, '6-49-B01', TRUE),
(6, 50, '6-50-B01', TRUE), (6, 51, '6-51-B01', TRUE), (6, 52, '6-52-B01', TRUE), (6, 53, '6-53-B01', TRUE),
(6, 54, '6-54-B01', TRUE), (6, 55, '6-55-B01', TRUE), (6, 56, '6-56-B01', TRUE), (6, 57, '6-57-B01', TRUE),
(6, 58, '6-58-B01', TRUE), (6, 59, '6-59-B01', TRUE), (6, 60, '6-60-B01', TRUE), (6, 61, '6-61-B01', TRUE),
(6, 62, '6-62-B01', TRUE), (6, 63, '6-63-B01', TRUE), (6, 64, '6-64-B01', TRUE), (6, 65, '6-65-B01', TRUE),
(6, 66, '6-66-B01', TRUE), (6, 67, '6-67-B01', TRUE), (6, 68, '6-68-B01', TRUE), (6, 69, '6-69-B01', TRUE),
(6, 70, '6-70-B01', TRUE), (6, 71, '6-71-B01', TRUE), (6, 72, '6-72-B01', TRUE), (6, 73, '6-73-B01', TRUE),
(6, 74, '6-74-B01', TRUE), (6, 75, '6-75-B01', TRUE), (6, 76, '6-76-B01', TRUE), (6, 77, '6-77-B01', TRUE),
(6, 78, '6-78-B01', TRUE), (6, 79, '6-79-B01', TRUE), (6, 80, '6-80-B01', TRUE), (6, 81, '6-81-B01', TRUE),
(6, 82, '6-82-B01', TRUE), (6, 83, '6-83-B01', TRUE),
(7, 22, '7-22-B01', TRUE), (7, 23, '7-23-B01', TRUE), (7, 24, '7-24-B01', TRUE), (7, 25, '7-25-B01', TRUE),
(7, 26, '7-26-B01', TRUE), (7, 27, '7-27-B01', TRUE), (7, 28, '7-28-B01', TRUE), (7, 29, '7-29-B01', TRUE),
(7, 30, '7-30-B01', TRUE), (7, 31, '7-31-B01', TRUE), (7, 32, '7-32-B01', TRUE), (7, 33, '7-33-B01', TRUE),
(7, 34, '7-34-B01', TRUE), (7, 35, '7-35-B01', TRUE), (7, 36, '7-36-B01', TRUE), (7, 37, '7-37-B01', TRUE),
(7, 38, '7-38-B01', TRUE), (7, 39, '7-39-B01', TRUE), (7, 40, '7-40-B01', TRUE), (7, 41, '7-41-B01', TRUE),
(7, 42, '7-42-B01', TRUE), (7, 43, '7-43-B01', TRUE), (7, 44, '7-44-B01', TRUE), (7, 45, '7-45-B01', TRUE),
(7, 46, '7-46-B01', TRUE), (7, 47, '7-47-B01', TRUE), (7, 48, '7-48-B01', TRUE), (7, 49, '7-49-B01', TRUE),
(7, 50, '7-50-B01', TRUE), (7, 51, '7-51-B01', TRUE), (7, 52, '7-52-B01', TRUE), (7, 53, '7-53-B01', TRUE),
(7, 54, '7-54-B01', TRUE), (7, 55, '7-55-B01', TRUE), (7, 56, '7-56-B01', TRUE), (7, 57, '7-57-B01', TRUE),
(7, 58, '7-58-B01', TRUE), (7, 59, '7-59-B01', TRUE), (7, 60, '7-60-B01', TRUE), (7, 61, '7-61-B01', TRUE),
(7, 62, '7-62-B01', TRUE), (7, 63, '7-63-B01', TRUE), (7, 64, '7-64-B01', TRUE), (7, 65, '7-65-B01', TRUE),
(7, 66, '7-66-B01', TRUE), (7, 67, '7-67-B01', TRUE), (7, 68, '7-68-B01', TRUE), (7, 69, '7-69-B01', TRUE),
(7, 70, '7-70-B01', TRUE), (7, 71, '7-71-B01', TRUE), (7, 72, '7-72-B01', TRUE), (7, 73, '7-73-B01', TRUE),
(7, 74, '7-74-B01', TRUE), (7, 75, '7-75-B01', TRUE), (7, 76, '7-76-B01', TRUE), (7, 77, '7-77-B01', TRUE),
(7, 78, '7-78-B01', TRUE), (7, 79, '7-79-B01', TRUE), (7, 80, '7-80-B01', TRUE), (7, 81, '7-81-B01', TRUE),
(7, 82, '7-82-B01', TRUE), (7, 83, '7-83-B01', TRUE),
(8, 22, '8-22-B01', TRUE), (8, 23, '8-23-B01', TRUE), (8, 24, '8-24-B01', TRUE), (8, 25, '8-25-B01', TRUE),
(8, 26, '8-26-B01', TRUE), (8, 27, '8-27-B01', TRUE), (8, 28, '8-28-B01', TRUE), (8, 29, '8-29-B01', TRUE),
(8, 30, '8-30-B01', TRUE), (8, 31, '8-31-B01', TRUE), (8, 32, '8-32-B01', TRUE), (8, 33, '8-33-B01', TRUE),
(8, 34, '8-34-B01', TRUE), (8, 35, '8-35-B01', TRUE), (8, 36, '8-36-B01', TRUE), (8, 37, '8-37-B01', TRUE),
(8, 38, '8-38-B01', TRUE), (8, 39, '8-39-B01', TRUE), (8, 40, '8-40-B01', TRUE), (8, 41, '8-41-B01', TRUE),
(8, 42, '8-42-B01', TRUE), (8, 43, '8-43-B01', TRUE), (8, 44, '8-44-B01', TRUE), (8, 45, '8-45-B01', TRUE),
(8, 46, '8-46-B01', TRUE), (8, 47, '8-47-B01', TRUE), (8, 48, '8-48-B01', TRUE), (8, 49, '8-49-B01', TRUE),
(8, 50, '8-50-B01', TRUE), (8, 51, '8-51-B01', TRUE), (8, 52, '8-52-B01', TRUE), (8, 53, '8-53-B01', TRUE),
(8, 54, '8-54-B01', TRUE), (8, 55, '8-55-B01', TRUE), (8, 56, '8-56-B01', TRUE), (8, 57, '8-57-B01', TRUE),
(8, 58, '8-58-B01', TRUE), (8, 59, '8-59-B01', TRUE), (8, 60, '8-60-B01', TRUE), (8, 61, '8-61-B01', TRUE),
(8, 62, '8-62-B01', TRUE), (8, 63, '8-63-B01', TRUE), (8, 64, '8-64-B01', TRUE), (8, 65, '8-65-B01', TRUE),
(8, 66, '8-66-B01', TRUE), (8, 67, '8-67-B01', TRUE), (8, 68, '8-68-B01', TRUE), (8, 69, '8-69-B01', TRUE),
(8, 70, '8-70-B01', TRUE), (8, 71, '8-71-B01', TRUE), (8, 72, '8-72-B01', TRUE), (8, 73, '8-73-B01', TRUE),
(8, 74, '8-74-B01', TRUE), (8, 75, '8-75-B01', TRUE), (8, 76, '8-76-B01', TRUE), (8, 77, '8-77-B01', TRUE),
(8, 78, '8-78-B01', TRUE), (8, 79, '8-79-B01', TRUE), (8, 80, '8-80-B01', TRUE), (8, 81, '8-81-B01', TRUE),
(8, 82, '8-82-B01', TRUE), (8, 83, '8-83-B01', TRUE),
(9, 22, '9-22-B01', TRUE), (9, 23, '9-23-B01', TRUE), (9, 24, '9-24-B01', TRUE), (9, 25, '9-25-B01', TRUE),
(9, 26, '9-26-B01', TRUE), (9, 27, '9-27-B01', TRUE), (9, 28, '9-28-B01', TRUE), (9, 29, '9-29-B01', TRUE),
(9, 30, '9-30-B01', TRUE), (9, 31, '9-31-B01', TRUE), (9, 32, '9-32-B01', TRUE), (9, 33, '9-33-B01', TRUE),
(9, 34, '9-34-B01', TRUE), (9, 35, '9-35-B01', TRUE), (9, 36, '9-36-B01', TRUE), (9, 37, '9-37-B01', TRUE),
(9, 38, '9-38-B01', TRUE), (9, 39, '9-39-B01', TRUE), (9, 40, '9-40-B01', TRUE), (9, 41, '9-41-B01', TRUE),
(9, 42, '9-42-B01', TRUE), (9, 43, '9-43-B01', TRUE), (9, 44, '9-44-B01', TRUE), (9, 45, '9-45-B01', TRUE),
(9, 46, '9-46-B01', TRUE), (9, 47, '9-47-B01', TRUE), (9, 48, '9-48-B01', TRUE), (9, 49, '9-49-B01', TRUE),
(9, 50, '9-50-B01', TRUE), (9, 51, '9-51-B01', TRUE), (9, 52, '9-52-B01', TRUE), (9, 53, '9-53-B01', TRUE),
(9, 54, '9-54-B01', TRUE), (9, 55, '9-55-B01', TRUE), (9, 56, '9-56-B01', TRUE), (9, 57, '9-57-B01', TRUE),
(9, 58, '9-58-B01', TRUE), (9, 59, '9-59-B01', TRUE), (9, 60, '9-60-B01', TRUE), (9, 61, '9-61-B01', TRUE),
(9, 62, '9-62-B01', TRUE), (9, 63, '9-63-B01', TRUE), (9, 64, '9-64-B01', TRUE), (9, 65, '9-65-B01', TRUE),
(9, 66, '9-66-B01', TRUE), (9, 67, '9-67-B01', TRUE), (9, 68, '9-68-B01', TRUE), (9, 69, '9-69-B01', TRUE),
(9, 70, '9-70-B01', TRUE), (9, 71, '9-71-B01', TRUE), (9, 72, '9-72-B01', TRUE), (9, 73, '9-73-B01', TRUE),
(9, 74, '9-74-B01', TRUE), (9, 75, '9-75-B01', TRUE), (9, 76, '9-76-B01', TRUE), (9, 77, '9-77-B01', TRUE),
(9, 78, '9-78-B01', TRUE), (9, 79, '9-79-B01', TRUE), (9, 80, '9-80-B01', TRUE), (9, 81, '9-81-B01', TRUE),
(9, 82, '9-82-B01', TRUE), (9, 83, '9-83-B01', TRUE),
(10, 22, '10-22-B01', TRUE), (10, 23, '10-23-B01', TRUE), (10, 24, '10-24-B01', TRUE), (10, 25, '10-25-B01', TRUE),
(10, 26, '10-26-B01', TRUE), (10, 27, '10-27-B01', TRUE), (10, 28, '10-28-B01', TRUE), (10, 29, '10-29-B01', TRUE),
(10, 30, '10-30-B01', TRUE), (10, 31, '10-31-B01', TRUE), (10, 32, '10-32-B01', TRUE), (10, 33, '10-33-B01', TRUE),
(10, 34, '10-34-B01', TRUE), (10, 35, '10-35-B01', TRUE), (10, 36, '10-36-B01', TRUE), (10, 37, '10-37-B01', TRUE),
(10, 38, '10-38-B01', TRUE), (10, 39, '10-39-B01', TRUE), (10, 40, '10-40-B01', TRUE), (10, 41, '10-41-B01', TRUE),
(10, 42, '10-42-B01', TRUE), (10, 43, '10-43-B01', TRUE), (10, 44, '10-44-B01', TRUE), (10, 45, '10-45-B01', TRUE),
(10, 46, '10-46-B01', TRUE), (10, 47, '10-47-B01', TRUE), (10, 48, '10-48-B01', TRUE), (10, 49, '10-49-B01', TRUE),
(10, 50, '10-50-B01', TRUE), (10, 51, '10-51-B01', TRUE), (10, 52, '10-52-B01', TRUE), (10, 53, '10-53-B01', TRUE),
(10, 54, '10-54-B01', TRUE), (10, 55, '10-55-B01', TRUE), (10, 56, '10-56-B01', TRUE), (10, 57, '10-57-B01', TRUE),
(10, 58, '10-58-B01', TRUE), (10, 59, '10-59-B01', TRUE), (10, 60, '10-60-B01', TRUE), (10, 61, '10-61-B01', TRUE),
(10, 62, '10-62-B01', TRUE), (10, 63, '10-63-B01', TRUE), (10, 64, '10-64-B01', TRUE), (10, 65, '10-65-B01', TRUE),
(10, 66, '10-66-B01', TRUE), (10, 67, '10-67-B01', TRUE), (10, 68, '10-68-B01', TRUE), (10, 69, '10-69-B01', TRUE),
(10, 70, '10-70-B01', TRUE), (10, 71, '10-71-B01', TRUE), (10, 72, '10-72-B01', TRUE), (10, 73, '10-73-B01', TRUE),
(10, 74, '10-74-B01', TRUE), (10, 75, '10-75-B01', TRUE), (10, 76, '10-76-B01', TRUE), (10, 77, '10-77-B01', TRUE),
(10, 78, '10-78-B01', TRUE), (10, 79, '10-79-B01', TRUE), (10, 80, '10-80-B01', TRUE), (10, 81, '10-81-B01', TRUE),
(10, 82, '10-82-B01', TRUE), (10, 83, '10-83-B01', TRUE),
(11, 22, '11-22-B01', TRUE), (11, 23, '11-23-B01', TRUE), (11, 24, '11-24-B01', TRUE), (11, 25, '11-25-B01', TRUE),
(11, 26, '11-26-B01', TRUE), (11, 27, '11-27-B01', TRUE), (11, 28, '11-28-B01', TRUE), (11, 29, '11-29-B01', TRUE),
(11, 30, '11-30-B01', TRUE), (11, 31, '11-31-B01', TRUE), (11, 32, '11-32-B01', TRUE), (11, 33, '11-33-B01', TRUE),
(11, 34, '11-34-B01', TRUE), (11, 35, '11-35-B01', TRUE), (11, 36, '11-36-B01', TRUE), (11, 37, '11-37-B01', TRUE),
(11, 38, '11-38-B01', TRUE), (11, 39, '11-39-B01', TRUE), (11, 40, '11-40-B01', TRUE), (11, 41, '11-41-B01', TRUE),
(11, 42, '11-42-B01', TRUE), (11, 43, '11-43-B01', TRUE), (11, 44, '11-44-B01', TRUE), (11, 45, '11-45-B01', TRUE),
(11, 46, '11-46-B01', TRUE), (11, 47, '11-47-B01', TRUE), (11, 48, '11-48-B01', TRUE), (11, 49, '11-49-B01', TRUE),
(11, 50, '11-50-B01', TRUE), (11, 51, '11-51-B01', TRUE), (11, 52, '11-52-B01', TRUE), (11, 53, '11-53-B01', TRUE),
(11, 54, '11-54-B01', TRUE), (11, 55, '11-55-B01', TRUE), (11, 56, '11-56-B01', TRUE), (11, 57, '11-57-B01', TRUE),
(11, 58, '11-58-B01', TRUE), (11, 59, '11-59-B01', TRUE), (11, 60, '11-60-B01', TRUE), (11, 61, '11-61-B01', TRUE),
(11, 62, '11-62-B01', TRUE), (11, 63, '11-63-B01', TRUE), (11, 64, '11-64-B01', TRUE), (11, 65, '11-65-B01', TRUE),
(11, 66, '11-66-B01', TRUE), (11, 67, '11-67-B01', TRUE), (11, 68, '11-68-B01', TRUE), (11, 69, '11-69-B01', TRUE),
(11, 70, '11-70-B01', TRUE), (11, 71, '11-71-B01', TRUE), (11, 72, '11-72-B01', TRUE), (11, 73, '11-73-B01', TRUE),
(11, 74, '11-74-B01', TRUE), (11, 75, '11-75-B01', TRUE), (11, 76, '11-76-B01', TRUE), (11, 77, '11-77-B01', TRUE),
(11, 78, '11-78-B01', TRUE), (11, 79, '11-79-B01', TRUE), (11, 80, '11-80-B01', TRUE), (11, 81, '11-81-B01', TRUE),
(11, 82, '11-82-B01', TRUE), (11, 83, '11-83-B01', TRUE);