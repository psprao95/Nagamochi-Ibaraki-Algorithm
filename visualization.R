data <- read.csv(file="/users/psprao/eclipse-workspace/Nagamochi-Ibaraki/output1.csv")

# Getting K, cost and density  data
m<-data[,1]
lambda<-data[,2]


# Scatterplot of K vs Cost of Network
plot(m,lambda,xlab="m",ylab="lambda(G) ",main="Number of Edges vs Edge")
lines(lambda~m)


data <- read.csv(file="/users/psprao/eclipse-workspace/Nagamochi-Ibaraki/output.csv")

# Getting K, cost and density  data
lambda<-data[,1]
spread<-data[,2]


# Scatterplot of K vs Cost of Network
plot(lambda,spread,xlab="lambda(G)",ylab="spread ",main="Spread of Edge Connectivities  ")
lines(spread~lambda)

