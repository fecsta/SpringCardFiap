CREATE TABLE if not exists TB_TRANSACAO (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    aluno_id integer NOT NULL,
    autorizadora varchar(20),
    valor decimal,
    CONSTRAINT FK_AlunoTransacao FOREIGN KEY (aluno_id) REFERENCES TB_ALUNO(id) ON DELETE CASCADE
);

DELETE FROM TB_TRANSACAO;

INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'MASTERCARD', 10.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(2, 'VISA', 20.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(3, 'CIELO', 30.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(4, 'AMEX', 40.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(5, 'MASTERCARD', 50.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(6, 'VISA', 60.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(7, 'CIELO', 70.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(8, 'AMEX', 80.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(9, 'MASTERCARD', 90.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(10, 'VISA', 100.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'MASTERCARD', 200.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(2, 'VISA', 300.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(3, 'MASTERCARD', 400.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(4, 'AMEX', 500.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(5, 'MASTERCARD', 600.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(6, 'VISA', 700.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(7, 'CIELO', 800.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(8, 'AMEX', 900.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(9, 'MASTERCARD', 1000.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'VISA', 1100.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(2, 'VISA', 1200.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(3, 'MASTERCARD', 1300.12);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(4, 'AMEX', 1400.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(5, 'MASTERCARD', 1500.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(6, 'VISA', 1600.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(7, 'CIELO', 1700.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(8, 'AMEX', 1800.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'MASTERCARD', 1900.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(2, 'VISA', 2000.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(3, 'CIELO', 2100.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(4, 'AMEX', 2200.00);


