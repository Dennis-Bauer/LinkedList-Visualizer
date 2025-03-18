# **Informationen zum Nutzen des Linked List Visualizers mit Java (German)**

Es gibt mehrere Möglichkeiten, dieses Projekt mit Java zu starten. Ich empfehle, die **.jar-Datei** zu nutzen, diese funktioniert momentan leider nur auf Computern mit **macOS**.

## **Nutze die .jar-Datei**

Um die **.jar-Datei** zu nutzen, führe diese Schritte aus:

- **Doppelklick**:  
  Versuche, die Datei mit einem **Doppelklick** auszuführen.  
  Wenn dies funktioniert, kannst du die nächsten Schritte überspringen.

- **Überprüfe Java**:  
  Öffne dein **Terminal** und führe den Befehl aus:
  ```bash
  java -version
  ```  
  Falls du **keine Zahlen** siehst, musst du **Java installieren**.  
  [Wie installiere ich Java?](#)

- **Öffne das Terminal**:  
  Öffne das **Terminal** im Verzeichnis, in dem sich die **.jar-Datei** befindet.
  - **Möglichkeit 1 (macOS)**:  
    Klicke mit der **rechten Maustaste** auf den Ordner mit der **.jar-Datei**.  
    Wähle entweder **"Neuer Terminal-Tab beim Ordner"** oder **"Neues Terminal beim Ordner"**.  
    Nun sollte sich ein **Terminalfenster** öffnen.
  - **Möglichkeit 2**:  
    Öffne das **Terminal** und navigiere mit folgendem Befehl zum Ordner:
    ```bash
    cd /Pfad/zum/OrdnerMitJar
    ```  
    Achte darauf, dass die **Verzeichnisangabe** vom **Wurzelverzeichnis der Festplatte** aus angegeben ist.

- **Führe die .jar-Datei aus**:  
  Nutze den Befehl:
  ```bash
  java -jar NAME.jar
  ```  
  Nun sollte das **Programm starten**.

## **Führe das Programm via IDE aus**

- **Installiere eine IDE (z. B. IntelliJ oder VSCode)**:  
  Du benötigst eine **IDE-Umgebung**. Ich empfehle **IntelliJ**, aber du kannst auch **VSCode** nutzen.  
  Allerdings habe ich mit **VSCode weniger gute Erfahrungen gemacht**.
  - **Installiere Maven**:  
    Falls du **VSCode** nutzt, installiere das Plugin **Maven for Java**.

- **Kopiere das Repository**:  
  Lade den gesamten Code auf deinen **PC** herunter und speichere ihn in einem **einzelnen Ordner**.  
  Öffne dann diesen **Ordner mit deiner IDE**.

- **Erstelle die `pom.xml`-Datei**:  
  Erstelle im Projektordner eine neue Datei namens **`pom.xml`**.  
  Der benötigte Inhalt für diese Datei ist weiter unten angegeben.

- **Projekt ausführen**:  
  Deine **IDE sollte das Projekt nun erkennen**.  
  Falls nicht, überprüfe **alle vorherigen Schritte** und kontrolliere die Datei **`pom.xml`**.  
  Es ist **wichtig**, dass dort **alles korrekt eingetragen** ist!


# **How to Use the Linked List Visualizer with Java (English)**

There are multiple ways to start this project with Java. I recommend using the **.jar file**, but it currently only works on **macOS** computers.

## **Using the .jar File**

To use the **.jar file**, follow these steps:

- **Double-click**:  
  Try running the file by **double-clicking** it.  
  If this works, you can skip the next steps.

- **Check Java**:  
  Open your **terminal** and run the following command:
  ```bash
  java -version
  ```  
  If you **don’t see any numbers**, you need to **install Java**.  
  [How do I install Java?](#)

- **Open the Terminal**:  
  Open the **terminal** in the directory where the **.jar file** is located.
  - **Option 1 (macOS)**:  
    Right-click on the **folder** containing the **.jar file**.  
    Select either **"New Terminal Tab at Folder"** or **"New Terminal at Folder"**.  
    A **terminal window** should now open.
  - **Option 2**:  
    Open the **terminal** and navigate to the folder using the following command:
    ```bash
    cd /Path/to/FolderWithJar
    ```  
    Make sure the **directory path starts from the root of your drive**.

- **Run the .jar File**:  
  Use the following command:
  ```bash
  java -jar NAME.jar
  ```  
  The **program should now start**.

## **Running the Program via an IDE**

- **Install an IDE (e.g., IntelliJ or VSCode)**:  
  You need an **IDE environment**. I recommend **IntelliJ**, but you can also use **VSCode**.  
  However, I’ve had **less positive experiences** with VSCode.
  - **Install Maven**:  
    If you use **VSCode**, install the **Maven for Java** plugin.

- **Clone the Repository**:  
  Download the **entire codebase** to your **PC** and place it in a **single folder**.  
  Then, open this **folder with your IDE**.

- **Create the `pom.xml` file**:  
  In the project folder, create a new file named **`pom.xml`**.  
  The required content for this file is provided below.

- **Run the Project**:  
  Your **IDE should now recognize the project**.  
  If it doesn’t, check **every previous step** and verify your **`pom.xml`** file.  
  It is **important** that everything is **entered correctly**!  

# **pom.xml**

```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>de.dennis</groupId>
    <artifactId>LinkedListVisualizer</artifactId>
    <version>1.0</version>
    <name>LinkedListVisualizer</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.10.2</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>22.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>22.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <source>22</source>
                    <target>22</target>
                </configuration>
            </plugin>

            <!-- JavaFX Maven Integration -->
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <executions>
                    <execution>
                        <id>default-cli</id>
                        <configuration>
                            <mainClass>de.dennis.llvisualizer.App</mainClass>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

```