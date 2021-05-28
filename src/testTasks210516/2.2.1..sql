 /*I have a table without PK or unique constraint.
 It has 5 columns, the last one is a timestamp.
 I need to apply a unique constraint on the first 4, if there are duplicates, I just want to keep the latest.
 How would you do it?*/

--Adaptation for ORACLE

DELETE TABLE1
  WHERE ROWID IN (SELECT id FROM (SELECT ROWID id,
                                         ROW_NUMBER() OVER (PARTITION BY COLUMN1, COLUMN2, COLUMN3, COLUMN4
                                                            ORDER BY COLUMN5 DESC) rn
                                    FROM TABLE1 t)
  WHERE rn > 1);
COMMIT;

ALTER TABLE TABLE1
  ADD CONSTRAINT UK_TABLE1 UNIQUE (COLUMN1, COLUMN2, COLUMN3, COLUMN4);