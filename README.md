Problem Formulation.
The problem currently will require a stochastic system model due to the random nature in which the components for 
Inspector 2 are selected. 

Setting of Objectives and overall project plan

My plan is to iteratively implement my complete solution to the simulation assignment as the deliverables are due. In 
this iteration of the project, I Implemented the model for the simulations to come, this includes the components, 
inspectors, buffers and workspaces. In the next iteration, I will be running the simulation and measuring the times that
the various tasks are taking. And then for the next deliverables I will be verifying and validating my design using the 
principles that we have learned in class.

Model Conceptualization

The model will be conceptualized through revision. In the third phase of this project, I will explore alternatives to
the original design. There are 3 main parts to my model, the components, the inspectors and the workspaces. Since there
are multiple types of each of these parts, for example there are inspectors 1 and 2, so for each of these parts I have 
implemented the factory pattern. The workstations have 2 buffers each, which will contain the queue for the components 
that have been inspected by the inspectors. 

Model Translation

The language I have chosen to implement the simulation in is Java. This is because I have a great deal of experience 
with the Java language, and I also believe that an object-oriented language, such as Java would be best for this type of
simulation. I think this because there are several instances of “classes” which function similarly, such as the 
workstations and component buffers which I believe would be easy to implement as several instances of the same class. 
I think this approach would also lend itself to more modification if it is needed in future iterations of the project. 
I also have more experience with file I/O actions than with other languages, which I think would be beneficial for the 
reading of the workstation service time data files
