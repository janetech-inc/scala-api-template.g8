# Janetech API Scaffold Template
Template for creating Janetech services

# Install g8 (Giter8)
brew update && brew install giter8


# Create new service API
<pre>
<b>sbt new janetech-inc/scala-api-template.g8 \</b>
--name="Product Service"

Ouputs:
Template applied in git/./product-service
</pre>


# Adding controllers
<pre>
<b>g8 janetech-inc/scala-api-template.g8</b>
--directory src/main/scaffolds/controller \
--out product-service \
--controller=buyer


Outputs:
Template applied in product-service
</pre>


Documentation:

Giter8 - http://www.foundweekends.org/giter8/formatting.html

SBT - https://www.scala-sbt.org/1.x/docs/index.html
