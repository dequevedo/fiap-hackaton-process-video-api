#!/bin/bash

set -e

echo "Aguardando LocalStack ficar disponível..."

until curl -s http://localhost:4566/_localstack/health | grep '"sqs": "running"' > /dev/null; do
  sleep 2
done

echo "LocalStack está pronto. Criando recursos..."

aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name hackaton-video-queue --region us-east-1

echo "Fila criada com sucesso."
