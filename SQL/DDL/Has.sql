CREATE TABLE jh203518.HAS(
    WebsiteURL VARCHAR(256) NOT NULL FOREIGN KEY(WebsiteURL) REFERENCES jh203518.WEBSITE(URL),
    MemberId INT NOT NULL FOREIGN KEY(MemberId) REFERENCES jh203518.MEMBER(Id)
)