Create table app.vendedor(
    cnpj varchar(18) not null
        constraint pk_vendedor primary key,
    nomeFantasia varchar(50) not null,
    descricao varchar(200)  not null,
    tel varchar(15) not null,
    endereco varchar(50) not null,
    email varchar(50) not null,
    login varchar(50) not null,
    senha varchar(50) not null
);

Create table app.categoria(
    idCategoria int not null generated always as identity
        constraint pk_categoria primary key,
    nome varchar(50) not null,
    descricao varchar(100) not null
);

Create table app.promocao(
    idPromocao int not null generated always as identity
        constraint pk_promocao primary key,
    cnpj varchar(18) not null,
        constraint fk_promocao_vendedor foreign key (cnpj) references app.vendedor,
    idCategoria int not null,
        constraint fk_promocao_categoria foreign key (idCategoria) references app.categoria,
    titulo varchar(50) not null,
    descricao varchar(200) not null,
    valor decimal(7,2) not null,
    imagem varchar(50) not null,
    quantidade int not null,
    tempo date not null
);

Create table app.voucher(
    idVoucher varchar(10) not null
        constraint pk_voucher primary key,
    idPromocao int not null,
        constraint fk_voucher_promocao foreign key (idPromocao) references app.promocao
);
