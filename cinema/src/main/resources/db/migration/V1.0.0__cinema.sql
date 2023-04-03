
    create table biglietto (
       id bigint not null auto_increment,
        version bigint,
        quantita integer not null,
        tipo varchar(255),
        posto_id bigint not null,
        utente_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table film (
       id bigint not null auto_increment,
        version bigint,
        descrizione varchar(255),
        eta_minima integer not null,
        regista varchar(255),
        titolo varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table posto (
       id bigint not null auto_increment,
        version bigint,
        disponibilita integer not null,
        proiezione_id bigint not null,
        sala_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table proiezione (
       id bigint not null auto_increment,
        version bigint,
        il date not null,
        prezzo decimal(4,2) not null,
        film_id bigint not null,
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
        data_nascita date not null,
        pwd varchar(255) not null,
        ruolo varchar(255) not null,
        usr varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table biglietto 
       add constraint UKnlpelv1b4xijdohi9sgximoqm unique (posto_id, utente_id, tipo);

    alter table posto 
       add constraint UKdx9j5stbrn6ncexn6htd822b9 unique (proiezione_id, sala_id);

    alter table proiezione 
       add constraint UKmb0kahv6koidw06d6u5sqkwd unique (film_id, il);

    alter table sala 
       add constraint UK_1xhvp29dwpod0att46kiwh5um unique (nome);

    alter table utente 
       add constraint UK_t5sf08b5wohp7622qaiq0a461 unique (usr);

    alter table biglietto 
       add constraint FKtf2ka68cjav2v8w2su0b2hxiw 
       foreign key (posto_id) 
       references posto (id);

    alter table biglietto 
       add constraint FK33t56je40vpfflkuawxeemmkg 
       foreign key (utente_id) 
       references utente (id);

    alter table posto 
       add constraint FKj28x0d2qdladv2f020sejdf84 
       foreign key (proiezione_id) 
       references proiezione (id);

    alter table posto 
       add constraint FKlxop66ef1oelrp5lh322r6iva 
       foreign key (sala_id) 
       references sala (id);

    alter table proiezione 
       add constraint FKmb04irqgc4qpd9ytbd8nhky79 
       foreign key (film_id) 
       references film (id);
