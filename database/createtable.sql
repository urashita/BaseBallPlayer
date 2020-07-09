/*-------------------------------------------------*/
/*                                                 */
/* テーブルの作成                                  */
/*                                                 */
/*-------------------------------------------------*/


/*-------------------------------------------------*/
/* テーブル名 MPlayer                             */
/*-------------------------------------------------*/
DROP TABLE if exists MPlayer;

CREATE TABLE MPlayer (
     id               INT NOT NULL AUTO_INCREMENT,
     name             VARCHAR(32),
     birthday         DATE,
     prefecture       VARCHAR(32),
     PRIMARY KEY (id)
);

INSERT INTO MPlayer (name, birthday, prefecture) VALUE
   ('能見　篤史',  '1979.05.28', '兵庫'),
   ('西　純矢',    '2001.09.13', '広島'),
   ('西　勇輝',    '1990.11.10', '三重'),
   ('岩貞　祐太',  '1991.09.05', '熊本');
