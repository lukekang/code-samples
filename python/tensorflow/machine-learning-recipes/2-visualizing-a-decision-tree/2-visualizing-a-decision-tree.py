import numpy as np
from sklearn.datasets import load_iris
from sklearn import tree

iris = load_iris() 

#### Info about the Iris dataset ####
# Iris dataset - https://en.wikipedia.org/wiki/Iris_flower_data_set#Data_set

# Here is the info regarding the Iris dataset and how it's used
print(iris.feature_names)
print(iris.target_names)
print(iris.data[0])
print(iris.target[0])

# Iris dataset detail:
for i in range(len(iris.target)):
    print('Example %d: label %s, features %s ' % (i, iris.target[i], iris.data[i]))

# The data should look like this: ['setosa' 'versicolor' 'virginica']
# so 0=setosa, 1=versicolor, 2=virginica

#### Train a classifier ####
# setosa is record 0, versicolor is at row 50 and virginica is 100
test_idx = [0, 50, 100]

## here the target represents the species, and the data is the feature set data
# training data - this should be the iris dataset with those 3 records deleted
train_target = np.delete(iris.target, test_idx)
train_data = np.delete(iris.data, test_idx, axis=0)

# testing data - this is just the 3 records
test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

# training
clf = tree.DecisionTreeClassifier()
clf.fit(train_data, train_target)

# test
print(test_target)
print(clf.predict(test_data))

# vizualization code - taken from: http://scikit-learn.org/stable/modules/tree.html#tree
from sklearn.externals.six import StringIO
import pydoc_data
import graphviz 

# create the dot data from the trained dtree
dot_data = tree.export_graphviz(clf, out_file=None, 
                         feature_names=iris.feature_names,  
                         class_names=iris.target_names,  
                         filled=True, rounded=True,  
                         special_characters=True)  
graph = graphviz.Source(dot_data)  

# saves rendered tree to disk: iris, iris.pdf
graph.render("iris") 



