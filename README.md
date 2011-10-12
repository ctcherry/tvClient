This is the start of a VLC based TV remote control script. Work in progress.

I have this working in Ruby, but I'm porting it to Java for the learning experience.

It works roughly something like this:

- script accepts command line arguments
- if the command line arguments correspond to a fixed command (ex: stop, pause, etc) then execute it
- else, the command line arguments are assumed to be search keywords
- take the keywords and ssh into the media server and use 'find' to locate matching media.
- script presents results to user
- user selects one
- if needed the script maps the path of the file from the media server to something the media player can use to access the file over the local network
- script sends correct VLC command sequence to the media player to play the file