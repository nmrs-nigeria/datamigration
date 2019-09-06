
CREATE OR REPLACE VIEW ENCOUNTER_TYPE_VIEW
AS
SELECT 
e.encounter_type AS EncounterTypeId,
(SELECT `name` FROM `location` AS l WHERE l.`location_id`= e.`location_id`) AS Location,
(SELECT `name` FROM `encounter_type` AS et WHERE et.`encounter_type_id` = e.`encounter_type`) AS EncounterType,
COUNT(encounter_type) AS NumberOfEncounters
FROM `encounter` e
GROUP BY `location_id`, e.encounter_type;

