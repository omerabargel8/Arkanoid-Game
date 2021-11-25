# 207041005
# abarzeo

compile: bin
	javac -cp biuoop-1.4.jar:src -d bin src/*.java 

run:
	java -cp biuoop-1.4.jar:bin Ass6Game 1 2 3 4

jar:
	jar cfm ass6game.jar Manifest.mf -C bin/ .

bin:
	mkdir bin