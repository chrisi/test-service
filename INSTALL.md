## Build Image

```bash
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=dockerhub.gtidev.net/airplus/test-service:latest
```

```bash
docker push dockerhub.gtidev.net/airplus/test-service:latest
```

## Deploy App

```bash
kubectl config set-context k3s-dev26
kubectl apply -n airplus -f deploy-a.yaml
kubectl apply -n airplus -f deploy-b.yaml
```

```bash
kubectl config set-context k3s-dev26
kubectl delete -n airplus -f deploy-a.yaml
kubectl delete -n airplus -f deploy-b.yaml
```
