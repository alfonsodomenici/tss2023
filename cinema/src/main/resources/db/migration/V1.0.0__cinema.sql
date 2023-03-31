
    create table biglietto (
       id bigint not null auto_increment,
        version bigint,
        tipo varchar(255),
        proiezione_id bigint,
        sala_id bigint,
        utente_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table disponibilita (
       id bigint not null auto_increment,
        version bigint,
        disponibilita integer not null,
        proiezione_id bigint,
        sala_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table film (
       id bigint not null auto_increment,
        version bigint,
        descrizione varchar(255),
        etaMinima integer not null,
        regista varchar(255),
        titolo varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table posti (
       proiezione_id bigint not null,
        disponibilita_id bigint not null,
        primary key (proiezione_id, disponibilita_id)
    ) engine=InnoDB;

    create table proiezione (
       id bigint not null auto_increment,
        version bigint,
        il datetime(6),
        prezzo decimal(4,2),
        film_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table sala (
       id bigint not null auto_increment,
        version bigint,
        nome varchar(255) not null,
        posti integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table utente (
       id bigint not null auto_increment,
        version bigint,
        pwd varchar(255) not null,
        ruolo integer,
        usr varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table utente 
       add constraint UK_t5sf08b5wohp7622qaiq0a461 unique (usr);

    alter table biglietto 
       add constraint FKglym5w5ndq52g7y5dvtrsuqoe 
       foreign key (proiezione_id) 
       references proiezione (id);

    alter table biglietto 
       add constraint FKr4o18p0b2qjeh5qgtqaxr37r3 
       foreign key (sala_id) 
       references sala (id);

    alter table biglietto 
       add constraint FK33t56je40vpfflkuawxeemmkg 
       foreign key (utente_id) 
       references utente (id);

    alter table disponibilita 
       add constraint FKffny6cugd8wcxlyrblijlr1tm 
       foreign key (proiezione_id) 
       references proiezione (id);

    alter table disponibilita 
       add constraint FKedg2n2eoi91nje7ga2x12xhdo 
       foreign key (sala_id) 
       references sala (id);

    alter table posti 
       add constraint FK2o9w8v1ytq4jn5ls33hw2mgp 
       foreign key (disponibilita_id) 
       references disponibilita (id);

    alter table posti 
       add constraint FKhtw383t1hftrityqf9pdvu28p 
       foreign key (proiezione_id) 
       references proiezione (id);

    alter table proiezione 
       add constraint FKmb04irqgc4qpd9ytbd8nhky79 
       foreign key (film_id) 
       references film (id);
