# ParkingMeter
O novo sistema de parquímetro foi projetado para lidar com a demanda crescente de estacionamento na
cidade. Ele oferece funcionalidades tais, como registro de condutores e veículos, controle de tempo estacionado,
opções flexíveis de pagamento e emissão de recibos.

---

# Documentação

## Rodar o banco de dados

Parar rodar o banco de dados, é necessário executar o Dockerfile, com os seguintes comandos:

```sql
docker build -f Dockerfile -t parkingmeter-local .
docker network create pg_network
docker run -d --network pg_network  -p 5432:5432 -v $(pwd):/parkingmeter/ parkingmeter-local
```

Opcional: para rodar o pgAdmin:

```sql
docker run -d --network pg_network -p 5050:5050 --name pgadmin-container -e PGADMIN_DEFAULT_EMAIL=user@example.com -e PGADMIN_DEFAULT_PASSWORD=SuperSecretPassword dpage/pgadmin4
```

## API para gestão de carros estacionados

1. O condutor se registra no sistema, fornecendo informações pessoais,  sua forma de pagamento preferida (cartão de crédito, débito ou PIX)
2. O condutor inicia o registro de tempo no sistema, escolhendo entre tempo fixo (indicando a duração desejada) ou
   por hora.
3. O sistema monitora o tempo de estacionamento e cobra o valor adequado com base nas opções de pagamento
   selecionadas.
4. Para horários fixos, o sistema emite um alerta quando o tempo está prestes a expirar.
5. Para períodos variáveis, o sistema emite um alerta informando que estenderá automaticamente o estacionamento
   por mais uma hora, a menos que o condutor desligue o registro.
6. Quando o tempo de estacionamento é encerrado, o sistema emite um recibo para o condutor.
