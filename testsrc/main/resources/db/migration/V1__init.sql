CREATE SEQUENCE public.hibernate_sequence;

CREATE TABLE Connection (
  uuid UUID NOT NULL
  scenarioID UUID
  providerUUID UUID NOT NULL
  consumerUUID UUID NOT NULL
  createdBy TEXT NOT NULL
  createdAt TIMESTAMP NOT NULL
  CONSTRAINT ConnectionPK PRIMARY KEY (uuid)
);

CREATE TABLE OtherThablle (
  uuid UUID NOT NULL
  scenarioID UUID NOT NULL
  someThing UUID NOT NULL
  createdBy TEXT NOT NULL
  createdAt TIMESTAMP NOT NULL
  CONSTRAINT OtherThabllePK PRIMARY KEY (uuid)
);