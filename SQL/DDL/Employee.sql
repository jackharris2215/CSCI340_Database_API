CREATE TABLE jh203518.EMPLOYEE
(
    Id INT CONSTRAINT PK_RESTRICTION_ID PRIMARY KEY,
    [Name] VARCHAR(100) NOT NULL,
    DateOfBirth DATE NOT NULL CHECK (DateOfBirth <= CAST(GETDATE() AS DATE)),
    WorkLocation INT NOT NULL CONSTRAINT FK_RESTRICTION_WORKLOCATION FOREIGN KEY(Id) REFERENCES jh203518.STORE(id)
);

GO

-- WorkLocation was wrong datatype
ALTER TABLE jh203518.EMPLOYEE
ALTER COLUMN WorkLocation INT NOT NULL FOREIGN KEY(Id) REFERENCES jh203518.STORE(id)

