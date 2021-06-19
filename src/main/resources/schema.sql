DROP TABLE IF EXISTS episode;
DROP TABLE IF EXISTS programset;

CREATE TABLE programset (
    id               INT PRIMARY KEY,
    numberOfElements SMALLINT      NOT NULL,
    synopsis         VARCHAR       NOT NULL,
    title            VARCHAR(255)  NOT NULL,
    organizationName VARCHAR(127)  NOT NULL,
    sharingUrl       VARCHAR(2047) NOT NULL,
    imageUrl         VARCHAR(2047) NOT NULL
);
CREATE TABLE episode (
    id                  INT PRIMARY KEY,
    duration            INT           NOT NULL,
    publicationDateTime TIMESTAMP     NOT NULL,
    title               VARCHAR(255)  NOT NULL,
    synopsis            VARCHAR       NOT NULL,
    playbackUrl         VARCHAR(2047) NOT NULL,
    downloadUrl         VARCHAR(2047) NOT NULL,
    sharingUrl          VARCHAR(2047) NOT NULL,
    squareImageUrl      VARCHAR(2047) NOT NULL,
    downloaded          BIT           NOT NULL,
    programset          INT           NOT NULL,
    FOREIGN KEY (programset) REFERENCES programset (id)
);
