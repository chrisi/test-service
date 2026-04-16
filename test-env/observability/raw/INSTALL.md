# Observability

```bash
kubectx minikube
kubectl apply -f namespace.yaml
```

```bash
kubectx minikube
kubectl apply -f alloy.yaml
kubectl apply -f grafana.yaml
kubectl apply -f loki.yaml
kubectl apply -f prometheus.yaml
kubectl apply -f tempo.yaml
```

```bash
kubectx minikube
kubectl delete -f alloy.yaml
kubectl delete -f grafana.yaml
kubectl delete -f loki.yaml
kubectl delete -f prometheus.yaml
kubectl delete -f tempo.yaml
```
