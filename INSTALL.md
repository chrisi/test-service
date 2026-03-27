## Build Image

```bash
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=dockerhub.gtidev.net/airplus/test-service
```

## Deploy App

```bash
kubectl apply -n airplus -f deploy-a.yaml
kubectl apply -n airplus -f deploy-b.yaml
```
