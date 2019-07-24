# Janetech API Scaffold Template
Template for creating Janetech services

# Install g8 (Giter8)
brew update && brew install giter8


# Creating a new api from this template
<pre>
<b>sbt new janetech-inc/scala-api-template.g8 \</b>
--name=Product Service \
--organzation=janetech.io

Ouputs:
Template applied in git/./product-service
</pre>


# Adding controllers
<pre>
g8 janetech-inc/scala-api-template.g8 --directory src/main/scaffolds/controller --out product-service \
--controller=buyer \
--controller=collection


Outputs:
Template applied in product-service
</pre>
