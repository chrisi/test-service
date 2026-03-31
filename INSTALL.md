## Build Image

```bash
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=test-service:latest
```

```bash
docker push dockerhub.gtidev.net/airplus/test-service:latest
```

```bash
docker rmi dockerhub.gtidev.net/airplus/test-service:latest
```

```bash
minikube image load test-service:latest
```

## Deploy App

```bash
kubectx k3s-dev26
kubectl apply -n airplus -f deploy-a.yaml
kubectl apply -n airplus -f deploy-b.yaml
```

```bash
kubectx k3s-dev26
kubectl delete -n airplus -f deploy-a.yaml
kubectl delete -n airplus -f deploy-b.yaml
```

```bash
kubectx minikube
kubectl apply -n default -f deploy-mini-a.yaml
kubectl apply -n default -f deploy-mini-b.yaml
```

```bash
kubectx minikube
kubectl delete -n default -f deploy-mini-a.yaml
```

```bash
kubectx minikube
kubectl apply -n default -f deploy-mongo.yaml
```