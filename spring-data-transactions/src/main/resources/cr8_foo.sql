PRAGMA auto_vacuum = 1;
PRAGMA encoding = "UTF-8";

DROP TABLE IF EXISTS "FOO";

CREATE TABLE "FOO"
(
    "ID"  INTEGER      CONSTRAINT "SECTION_PK" PRIMARY KEY,
    "FOO" VARCHAR(255) NOT NULL
);