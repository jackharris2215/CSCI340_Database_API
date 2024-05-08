INSERT INTO jh203518.STORE (Id, Address)
VALUES
    (123456789, 'Tea Express'),
    (234567890, 'Generic Tea Shop'),
    (345678901, 'Cool Place for Tea')

GO

INSERT INTO jh203518.EMPLOYEE (Id, [Name], DateOfBirth, WorkLocation)
VALUES
    ('11111', 'Abe', '2005-03-25', '345678901'),
    ('22222', 'Bree', '1998-11-10', '234567890'),
    ('33333', 'Charlie', '1987-07-05', '234567890'),
    ('44444', 'Danny', '2003-09-15', '345678901'),
    ('55555', 'Ed', '1979-02-28', '123456789'),
    ('66666', 'Francis', '1982-06-20', '123456789'),
    ('77777', 'George', '1995-08-12', '123456789'),
    ('88888', 'Harry', '2008-04-30', '345678901'),
    ('99999', 'Isabella', '1973-12-07', '234567890'),

GO

INSERT INTO jh203518.DEPARTMENT (Id, Address)
VALUES
    (000000001, 'TeaHQ')

GO

INSERT INTO jh203518.RUNS (EmployeeId, DepartmentId)
VALUES
    (11111, 000000001)

GO

INSERT INTO jh203518.MANAGES (EmployeeId, StoreId)
VALUES
    (22222, 234567890),
    (66666, 123456789),
    (88888, 345678901)

GO

INSERT INTO jh203518.PROJECT (Manager, Completion, Topic, Cost)
VALUES
    (33333, 'Just Beginning', 'New Sweet Teas', 15.88),
    (99999, '2 Days remaining', 'Promote Jasmine tea for chinese new year', 150.00)

GO

INSERT INTO jh203518.WEBSITE (URL, DailyVisitors, Manager)
VALUES
    ('http://teastuff.com', 100, 44444)

GO

INSERT INTO jh203518.MEMBER (Id, FirstName, LastName, RegisteredDate)
VALUES
    (001, 'Alex', 'Donovan', '05-04-2001'),
    (002, 'Barry', NULL, '03-04-2004'),
    (003, 'Charlie', 'Chaplin', '12-31-2022')

GO

INSERT INTO jh203518.HAS (WebsiteURL, MemberID)
VALUES
    ('http://teastuff.com', 001),
    ('http://teastuff.com', 002),
    ('http://teastuff.com', 003)

GO

INSERT INTO jh203518.PRODUCT (Id, Name, Supply, Cost, Volume, Material, Rating, [Size])
VALUES
    (0001, 'CoolKettle', 29, 9.99, 32, 'cast iron', 5, NULL),
    (0002, 'OkKettle', 2, 4.99, 32, 'steel', 2, NULL),
    (0003, 'Nice tea cup', 3, 9.99, 6, 'ceramic', 5, NULL),
    (0004, 'red strainer', 66, 2.99, NULL, NULL, 3, 'medium'),
    (0005, 'Nice plate', 11, 12.99, NULL, 'glass', 4, 'small')

GO

INSERT INTO jh203518.TEA (Name, [Type], BrewTemp, BrewTime, BrewQuantity, amount)
VALUES
    ('Jasmine', 'Green', 190.00, '3:00', 3, 26),
    ('Chamomile', 'Green', 209.00, '3:00', 3, 26),
    ('Lemon Grass', 'Herbal', 190.00, '2:50', 2, 18)

GO

INSERT INTO jh203518.SELLS (StoreId, ProductId, TeaName)
VALUES
    ('123456789', NULL, 'Jasmine'),
    ('123456789', 0002, NULL),
    ('123456789', 0003, NULL),
    ('234567890', NULL, 'Chamomile'),
    ('234567890', 0001, NULL),
    ('345678901', 0004, NULL),
    ('345678901', 0005, NULL),
    ('345678901', NULL, 'Lemon Grass')

GO

INSERT INTO jh203518.TRUCK (StoreId, EmployeeId, Efficiency, Cost)
VALUES
    ('123456789', 44444, '70 percent', 20.00),
    ('234567890', 55555, '75 percent', 22.01),
    ('345678901', 77777, '20 percent', 44.43)