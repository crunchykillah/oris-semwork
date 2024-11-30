create sequence authors_seq;
create sequence artworks_seq;
create sequence visitors_seq;
create sequence exhibitions_seq;



CREATE TABLE authors (
                         author_id bigint  primary key default nextval('authors_seq'),
                         name VARCHAR(100) NOT NULL,
                         birth_date DATE NOT NULL,
                         death_date DATE NOT NULL,
                         country VARCHAR(50)
);

CREATE TABLE artworks (
                          artwork_id bigint  primary key default nextval('artworks_seq'),
                          title VARCHAR(100) NOT NULL,
                          creation_year INT NOT NULL,
                          author_id INT NOT NULL,
                          FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

create table visitors (
                             visitor_id bigint  primary key default nextval('visitors_seq'),
                             name varchar(255) NOT NULL,
                             email varchar(255) NOT NULL,
                             username varchar(255) unique,
                             password varchar(255) NOT NULL,
                             phone_number varchar(255)
);

CREATE TABLE exhibitions (
                             exhibition_id bigint  primary key default nextval('exhibitions_seq'),
                             name VARCHAR(100) NOT NULL,
                             start_date DATE NOT NULL,
                             end_date DATE NOT NULL
);

CREATE TABLE exhibition_artworks (
                                     exhibition_id INT,
                                     artwork_id INT,
                                     FOREIGN KEY (exhibition_id) REFERENCES exhibitions(exhibition_id),
                                     FOREIGN KEY (artwork_id) REFERENCES artworks(artwork_id)
);

CREATE TABLE visitor_exhibitions (
                                     visitor_id INT,
                                     exhibition_id INT,
                                     FOREIGN KEY (visitor_id) REFERENCES visitors(visitor_id),
                                     FOREIGN KEY (exhibition_id) REFERENCES exhibitions(exhibition_id)
);
INSERT INTO authors (name, birth_date, death_date, country) VALUES
                                                                ('Leonardo da Vinci', '1452-04-15', '1519-05-02', 'Italy'),
                                                                ('Vincent van Gogh', '1853-03-30', '1890-07-29', 'Netherlands'),
                                                                ('Pablo Picasso', '1881-10-25', '1973-04-08', 'Spain'),
                                                                ('Claude Monet', '1840-11-14', '1926-12-05', 'France'),
                                                                ('Edgar Degas', '1834-07-19', '1917-09-27', 'France'),
                                                                ('Rembrandt', '1606-07-15', '1669-10-04', 'Netherlands');


INSERT INTO artworks (title, creation_year, author_id) VALUES
                                                           ('Mona Lisa', 1503, 1),
                                                           ('The Starry Night', 1889, 2),
                                                           ('Guernica', 1937, 3);

INSERT INTO visitors (name, email, username, password, phone_number) VALUES
                                                                         ('John Doe', 'john.doe@example.com', 'johndoe', 'password123', '+1234567890'),
                                                                         ('Jane Smith', 'jane.smith@example.com', 'janesmith', 'password123', '+0987654321');

INSERT INTO exhibitions (name, start_date, end_date) VALUES
                                                         ('Renaissance Art', '2023-01-01', '2023-12-31'),
                                                         ('Impressionism', '2023-01-01', '2023-12-31'),
                                                         ('Cubism', '2023-01-01', '2023-12-31');

INSERT INTO exhibition_artworks (exhibition_id, artwork_id) VALUES
                                                                (1, 1),
                                                                (2, 2),
                                                                (3, 3);

INSERT INTO visitor_exhibitions (visitor_id, exhibition_id) VALUES
                                                                (1, 1),
                                                                (1, 2),
                                                                (2, 2),
                                                                (2, 3);

INSERT INTO artworks (title, creation_year, author_id) VALUES
                                                           ('Water Lilies', 1899, 4),  -- Произведение Клода Моне
                                                           ('The Dance Class', 1874, 5),  -- Произведение Эдгара Дега
                                                           ('The Night Watch', 1642, 6);  -- Произведение Рембрандта
-- Добавляем новые произведения искусства для Леонардо да Винчи
INSERT INTO artworks (title, creation_year, author_id) VALUES
                                                           ('The Last Supper', 1498, 1),
                                                           ('Vitruvian Man', 1490, 1);

-- Добавляем новые произведения искусства для Винсента Ван Гога
INSERT INTO artworks (title, creation_year, author_id) VALUES
                                                           ('Sunflowers', 1888, 2),
                                                           ('Cafe Terrace at Night', 1888, 2);
-- Добавляем новые произведения искусства для Пабло Пикассо
INSERT INTO artworks (title, creation_year, author_id) VALUES
                                                           ('The Weeping Woman', 1937, 3),
                                                           ('Les Demoiselles d''Avignon', 1907, 3);