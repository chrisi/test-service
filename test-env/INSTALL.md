# Test Service

## Build Image

```bash
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=test-service:latest
```

## Kubernetes

### Push Image

```bash
docker tag test-service:latest dockerhub.gtidev.net/airplus/test-service:latest
docker push dockerhub.gtidev.net/airplus/test-service:latest
```

```bash
docker rmi dockerhub.gtidev.net/airplus/test-service:latest
```

### Deploy App

```bash
kubectx k3s-dev26
kubectl apply -n airplus -f service-a.yaml
kubectl apply -n airplus -f service-b.yaml
```

### Undeploy App

```bash
kubectx k3s-dev26
kubectl delete -n airplus -f service-a.yaml
kubectl delete -n airplus -f service-b.yaml
```

## Minikube

### Load Image

```bash
minikube image load test-service:latest
```

### Deploy App

```bash
kubectx minikube
kubectl apply -n default -f mini-a.yaml
kubectl apply -n default -f mini-b.yaml
```

### Undeploy App

```bash
kubectx minikube
kubectl delete -n default -f mini-a.yaml
kubectl delete -n default -f mini-b.yaml
```

# Database

## MongoDB

```bash
kubectx minikube
kubectl apply -n default -f mongodb.yaml
```
