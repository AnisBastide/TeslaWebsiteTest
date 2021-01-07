#Feature: Fonctionnalités de ma page d'accueil
#	Scenario: Vérification du titre et de la description
#		Given je suis sur la page "https://www.tesla.com/fr_fr"
#		Then le titre doit être "Voitures électriques, énergie solaire et propre | Tesla France"
#		And la description contient "Tesla accélère la transition mondiale vers une énergie durable en proposant des véhicules électriques, des panneaux solaires et des solutions intégrées d'énergie renouvelable pour les particuliers et les entreprises."
#	Scenario Outline: Verification des h1
#		Given je suis sur la page "https://www.tesla.com/fr_fr"
#		Then les titres de la page contiennent "<Title>"
#		Examples:
#		| Title |
#		| Model 3 |
#		| Model S |
#		| Model X |
#		| Model Y |
#		| Systèmes d'énergie solaire et Powerwalls |
#
#	Scenario Outline: Verification des lien de la navbar
#		Given je suis sur la page "https://www.tesla.com/fr_fr"
#		Then le lien du bouton "<name>" doit etre "<url>"
#		Examples:
#			| name      | url |
#			| Model S   |   https://www.tesla.com/fr_fr/models |
#			| Model 3   |   https://www.tesla.com/fr_fr/model3 |
#			| Model X   |   https://www.tesla.com/fr_fr/modelx |
#			| Model Y   |   https://www.tesla.com/fr_fr/modely |
#			| Powerwall |   https://www.tesla.com/fr_fr/powerwall |
#			| Recharger |   https://www.tesla.com/fr_fr/charging |
#		Scenario Outline:
#			Given je suis sur la page "https://www.tesla.com/fr_fr"
#			Then le burger contient le bouton "<name>"
#			Examples:
#			|name|
#			|  Véhicules disponibles  |
#			|  Véhicules d'occasion |
#			|  Reprise  |
#			|  Cybertruck  |
#			|  Roadster  |
#			|  Énergie  |
#			|  Essais  |
#			|  Flottes & Entreprises  |
#
#
