sourcePackages = \
	FenwickTree \
	CountMinSketch \

sourcefiles = \
		FenwickTree/FenwickTree.java \
		CountMinSketch/FrequencyEstimator.java \
		CountMinSketch/CountMinSketch.java \

classfiles = $(sourcefiles:.java=.class)

all: $(classfiles)
%.class: %.java
		javac -d . -classpath . $<

# TODO: Figure out how to make this remove ALL packages
clean: $(sourcePackages)
		rm -f ./$</*.class
		rm -rf ./njdup/$</
