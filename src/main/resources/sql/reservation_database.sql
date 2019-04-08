create table Evenement
(
    id            int auto_increment
        primary key,
    code          varchar(255) null,
    dateEvenement datetime     null,
    nom           varchar(255) null,
    constraint UK_bu07f00x6upvcvhy2ywpqir6a
        unique (code)
);

create table Reservation
(
    id              int auto_increment
        primary key,
    dateReservation datetime null,
    evenement_id    int      not null,
    constraint FKerw1dwx8j4haafayn4knroyrk
        foreign key (evenement_id) references Evenement (id)
);

create table Personne
(
    id             int auto_increment
        primary key,
    nom            varchar(255) null,
    reservation_id int          null,
    constraint FK5lb833xs24d4n09jcodyq8r82
        foreign key (reservation_id) references Reservation (id)
);