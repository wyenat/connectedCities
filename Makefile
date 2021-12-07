all: compile

compile:
	javac -d bin -sourcepath src src/com/cities/CommandParser.java

test:
	@echo "Testing: Subject examples"
	java -cp bin com.cities.CommandParser src/resources/cities.txt "New York" Boston
	java -cp bin com.cities.CommandParser src/resources/cities.txt Boston Pittsburgh
	java -cp bin com.cities.CommandParser src/resources/cities.txt Boston Tampa
	java -cp bin com.cities.CommandParser src/resources/cities.txt Boston Ypsilanti
	@echo "Testing: 2 cities connected in a slightly bigger graph. Should be yes."
	java -Xss3000k -cp bin com.cities.CommandParser src/resources/citiesFrance.txt Lintal Malroi
	@echo "Testing: 2 cities not connected in a slightly bigger graph. Should be no."
	java -Xss3000k -cp bin com.cities.CommandParser src/resources/citiesFrance.txt Colmar Papeete
	@echo "Testing: 2 cities connected with 50000 cities between them. Should be yes."
	java -Xss3000k -cp bin com.cities.CommandParser src/resources/10000cities.txt City1 City40161 2> /dev/null
	@echo "Testing: 2 cities not connected in a 50000 cities graph. Should be no."
	java -Xss3000k -cp bin com.cities.CommandParser src/resources/10000cities.txt City1 City40162 2> /dev/null

doc:
	javadoc io -sourcepath src -d doc

clean:
	rm -rf bin/*