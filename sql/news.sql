CREATE TABLE news (
                      id int NOT NULL,
                      title nclob NOT NULL,
                      author nclob NOT NULL,
                      content nclob NOT NULL,
                      timecreated timestamp NOT NULL ,
                      timeupdate timestamp NOT NULL ,
                      PRIMARY KEY (id)
);
CREATE TABLE comments (
                          id int NOT NULL,
                          content nclob NOT NULL,
                          timepost timestamp NOT NULL,
                          newsid int,
                          PRIMARY KEY (id),
                          CONSTRAINT FK_news FOREIGN KEY (newsid) REFERENCES news(id)
);