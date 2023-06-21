CREATE SEQUENCE public.hibernate_sequence;

CREATE TABLE connections (
  uuid UUID false
  scenarioID UUID false
  providerUUID UUID false
  consumerUUID UUID false
  createdBy TEXT false
  createdAt TIMESTAMP false
  CONSTRAINT primaryKey PRIMARY KEY (uuid)
);

CREATE TABLE OtherThablle (
  uuid UUID false
  scenarioID UUID false
  providerUUID UUID false
  consumerUUID UUID false
  createdBy TEXT false
  createdAt TIMESTAMP false
  CONSTRAINT primaryKey PRIMARY KEY (uuid)
);