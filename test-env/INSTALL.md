# Test Service

## Build Image

```bash
cd ..
mvn clean package spring-boot:build-image -DskipTests -Dspring-boot.build-image.imageName=test-service:latest
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
minikube image rm docker.io/library/test-service:latest
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

## Prepare Minikube

### Reset

```bash
minikube delete
minikube start #--cpus 4 --memory 8192
```

### MongoDB

```bash
kubectx minikube

kubectl apply -n default -f mongodb.yaml
```

### Cilium

* https://chatgpt.com/c/69c6ecb2-ba3c-8394-8cc9-2973e63e7e53

```bash
brew install cilium-cli
```

```bash
kubectx minikube

cilium install #--version 1.19.2

cilium status --wait
```

```bash
kubectx minikube

cilium hubble enable --ui

cilium status --wait
```

```bash
cilium hubble ui
```

```bash
cilium hubble port-forward&

hubble status

hubble observe
```

### Traefik

* https://chatgpt.com/c/69cbacce-a378-838c-9aae-c2e614174fa2
* https://gemini.google.com/share/de92f5fae1f5

```bash
helm repo add traefik https://traefik.github.io/charts
helm repo update
```

```bash
kubectx minikube

helm upgrade --install traefik traefik/traefik \
  -n traefik \
  --create-namespace \
  --set ingressRoute.dashboard.enabled=true

kubectl rollout status deployment/traefik -n traefik
```

Get the external IP of traefik

```bash
kubectl get svc traefik
```

Add the IP to `/etc/hosts` like

```
<EXTERNAL-IP> traefik.mk
```

```bash
minikube tunnel
```

```bash
kubectl port-forward -n traefik deploy/traefik 9090:8080

http://localhost:9090/dashboard/
```

### Test the Service

```bash
curl http://traefik.mk/service-a/echo?name=Chrisi
curl http://traefik.mk/service-a/echo?name=Steffi
curl http://traefik.mk/service-a/remoteecho?name=Hannah
curl http://traefik.mk/service-a/remoteecho?name=Elisa
```
