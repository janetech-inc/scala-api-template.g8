#!/usr/bin/env bash

TARGET_GROUP_ARN=$(aws ecs describe-services --cluster ${AWS_RESOURCE_NAME_PREFIX}-cluster-${AWS_RESOURCE_NAME_SUFFIX} --services ${AWS_RESOURCE_NAME_PREFIX}-service-${AWS_RESOURCE_NAME_SUFFIX} | jq -r '.services[0].loadBalancers[0].targetGroupArn')
ELB_ARN=$(aws elbv2 describe-target-groups --target-group-arns $TARGET_GROUP_ARN | jq -r '.TargetGroups[0].LoadBalancerArns[0]')
ELB_DNS_NAME=$(aws elbv2 describe-load-balancers --load-balancer-arns $ELB_ARN | jq -r '.LoadBalancers[0].DNSName')
curl -s --retry 10 http://$ELB_DNS_NAME | grep "theCXN"