---
sidebar_position: 4
---

# 连接到 Kubernetes 集群

你可以连接到现有的 Kubernetes 集群，我们会下载 `kubectl` 用于和集群通信。

在使用前，你需要配置凭证信息，下面是一份 RBAC 权限的参考:

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

这个配置将会提供如下权限：
- 列出所有命名空间
- 列出指定命名空间下所有 Pod
- 查看指定命名空间下的 Pod
- 对指定命名空间下 Pod exec 的权限