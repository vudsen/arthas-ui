---
sidebar_position: 4
---

# Connect To Kubernetes Cluster

You can connect to an existing Kubernetes cluster, and we will download `kubectl` to communicate with the cluster.

Before use, you need to configure your credentials. Below is a reference for RBAC permissions:

```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: Role
metadata:
  name: ci-role
  namespace: <namespace>
rules:
  - apiGroups: [""]
    resources: ["pods"]
    verbs:
      - get
      - list
      - watch
  - apiGroups: [""]
    resources: ["pods/exec"]
    verbs:
      - get
      - post
  - apiGroups: [""]
    resources: ["namespaces"]
    verbs:
      - get
      - list
      - watch
---
apiVersion: rbac.authorization.k8s.io/v1
kind: RoleBinding
metadata:
  name: ci-role-biding
  namespace: <namespace>
subjects:
  - kind: ServiceAccount
    name: <service_account_name>
    apiGroup: ""
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: Role
  name: ci-role
---
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRole
metadata:
  name: list-namespaces
rules:
  - apiGroups: [""]
    resources: ["namespaces"]
    verbs: ["list"]
---
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRoleBinding
metadata:
  name: list-namespaces-binding
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: list-namespaces
subjects:
  - kind: ServiceAccount
    name: <service_account_name>
    namespace: <namespace>
```

This configuration will provide the following permissions:
- List all namespaces
- List all Pods under a specified namespace
- View Pods under a specified namespace
- Permission to exec Pods under a specified namespace