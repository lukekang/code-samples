from sklearn import tree

'''
This is the hello world example from the Tensorflow tutorial
on YouTube.
'''

'''
Collect training data -> train classifier -> make predictions 
'''

'''
# Features are 
- Weight in grams
- Texture:
    0 = bumpy
    1 = smooth          
- Label:
    0 = apple
    1 = orange

Wgt | Texture | Label
140 | smooth  | apple 
130 | smooth  | apple
150 | bumpy   | orange
170 | bumpy   | orange
'''
'''
Decision tree:
                                            yes --> Orange
                                             |
                  yes --> Texture == bumpy? -+
                   |                         |
  Weight >= 150g? -+                        no  --> Apple                 
                   |                        
                   no

'''

# weight and texture 
features = [[140, 1], [130, 1], [150, 0], [170, 0]]
labels = [0, 0, 1, 1]

# Classifier is like a 'box of rules'
clf = tree.DecisionTreeClassifier() # right now it's an empty box of rules

clf = clf.fit(features, labels) # fit is like "find patterns in data"


# weight of 149, texture is bumpy
if clf.predict([[149, 0]]) == 1:
    print("That's an orange")
else:
    print("You've got yourself an apple")
