#!/bin/bash
#
# Define the path to your chess_project directory
CHESS_PROJECT_DIR="$(pwd)" # Use current directory
#
# Define the path to your compiled Java classes
CLASS_PATH="$CHESS_PROJECT_DIR/main"
#
# Define the main class to execute
MAIN_CLASS="main.Main"
#
# Create the chesscli script
cat <<EOF > chesscli
#!/bin/bash
java -cp "$CLASS_PATH" "$MAIN_CLASS"
EOF
#
# Make the script executable
chmod +x chesscli
#
# Move the script to /usr/local/bin or ~/bin
if [ -d "/usr/local/bin" ] && [ "$(id -u)" -eq 0 ]; then
  sudo mv chesscli /usr/local/bin/
  echo "chesscli installed to /usr/local/bin"
elif [ -d "$HOME/bin" ]; then
  mv chesscli "$HOME/bin"
  echo "chesscli installed to ~/bin"
  echo "Remember to add ~/bin to your PATH if it's not already."
else
  mkdir "$HOME/bin"
  mv chesscli "$HOME/bin"
  echo "chesscli installed to ~/bin"
  echo "Remember to add ~/bin to your PATH if it's not already."
fi
#
# Compile the Java code
javac main/**/*.java
#
echo "Installation complete! You can now run the game by typing 'chesscli' in your terminal."
#
#
#