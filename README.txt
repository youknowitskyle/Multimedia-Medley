Kyle Wong

Programming solution:

Image scaling: uses ScaleGestureDetector to detect pinching gesture and uses the scale factor to appropriately scale the image

Video playback: uses a VideoView to display a raw video file

Text to speech: uses Android TextToSpeech class to get text from a textview and read it out loud

Speech to text: Uses RecognizerIntent to initiate built in speech to text process

Fireworks: Uses provided animation thread to update particles that originate from a tap gesture. Each particle uses the animation thread to update its position by a unique factor every 1/60 of a second. A callback function is employed to trigger the invalidate() function needed to redraw the points.

Extra credit was not tackled.