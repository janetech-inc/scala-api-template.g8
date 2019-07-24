# Janetech API Scaffold Template
Template for creating Janetech services

# Install g8 (Giter8)
brew update && brew install giter8


# Creating a new api from this template
<pre>
<b>sbt new janetech-inc/scala-api-template.g8</b>

/***********************************************************/

     name [Janetech API Seed Tempalte]: Product Service
     organization [janetech.io]: 

/***********************************************************/

Template applied in git/./product-service

cd ~/git/product-service

</pre>


# Adding controllers
<pre>
g8 janetech-inc/scala-api-template.g8 --directory src/main/scaffolds/controller --out product-service \
--controller=buyer \
--controller=collection \


Output:
Template applied in product-service

</pre>
