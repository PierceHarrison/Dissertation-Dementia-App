package com.example.dissertation_dementia_app

//Imports for AudioActivity
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_audio.*
//Code taken from JavaTPoint available at https://www.javatpoint.com/kotlin-android-media-player and adapted by Pierce Harrison
class AudioActivity : AppCompatActivity() {

    //Initialising variables for use in the class
    //Initialises the mediaPlayer variable to the built in MediaPlayer class
    private lateinit var mediaPlayer: MediaPlayer
    //Initialises the runnable variable to the built in Runnable interface
    private lateinit var runnable:Runnable
    //Initialises the handler variable to the built in Handler class
    private var handler: Handler = Handler()
    //Initialises the pause variable to be a boolean that is set to false
    private var pause:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        // Start the media player on clicking the play button
        playBtn.setOnClickListener{
            if(pause){
                //set mediaPlayer to start at the current time position
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                //Start the media player to play the music
                mediaPlayer.start()
                //Set pause to false
                pause = false
                //Make a Toast output telling the user that media is playing
                Toast.makeText(this,"music playing",Toast.LENGTH_SHORT).show()
            }else{

//                mediaPlayer = MediaPlayer.create(applicationContext,R.raw.bensound)
                //Set the mediaPlayer to a newly created mediaPlayer with a sound loaded
                mediaPlayer = MediaPlayer.create(applicationContext,R.raw.skipinnish)
                //Start the mediaPlayer to play the music
                mediaPlayer.start()
                //Toast output to tell the user that media is playing
                Toast.makeText(this,"music playing",Toast.LENGTH_SHORT).show()

            }
            //Run initialiseSeekBar() function
            initialiseSeekBar()

            //Set playBtn to be disabled as when playing the music there is no need to have it enabled
            playBtn.isEnabled = false
            //Set pauseBtn to be enabled as when playing music the music may be paused
            pauseBtn.isEnabled = true
            //Set stopBtn to be enabled as when playing music the music may be stopped
            stopBtn.isEnabled = true

            //Sets an on completion listener to check when the music has ended.
            mediaPlayer.setOnCompletionListener {
                //Set playBtn to enabled as when music is finished playing it can be played again
                playBtn.isEnabled = true
                //Set pauseBtn to disabled as when the music has ended there is no need to pause the music
                pauseBtn.isEnabled = false
                //Set stopBtn to disabled as when the music has ended there is no need to stop the music
                stopBtn.isEnabled = false
                //Toast message to show tell the user that the song has ended
                Toast.makeText(this,"End of Song",Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        pauseBtn.setOnClickListener {
            //If the mediaPlayer is currently playing
            if(mediaPlayer.isPlaying){
                //Pause the mediaPlayer
                mediaPlayer.pause()
                //Set pause to equal true
                pause = true
                //Set playBtn to be enabled so that the music can be played after being paused
                playBtn.isEnabled = true
                //Set pauseBtn to be disabled so that the music cannot be paused once it is already paused
                pauseBtn.isEnabled = false
                //Set the stopBtn to be enabled so that the music can be stopped after being paused.
                stopBtn.isEnabled = true
                //Toast message used to tell the user the music has been paused
                Toast.makeText(this,"music paused",Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
        stopBtn.setOnClickListener{
            //If the musicPlayer is playing or paused
            if(mediaPlayer.isPlaying || pause){
                //Set pause to equal false
                pause = false
                //Set the seekbar back to the start position
                seek_bar.progress = 0
                //Run the stop function on the mediaPlayer
                mediaPlayer.stop()
                //Run the reset function on the mediaPlayer
                mediaPlayer.reset()
                //Run the release function on the mediaPlayer
                mediaPlayer.release()
                //Remove any pending runnables from the message queue
                handler.removeCallbacks(runnable)

                //Set playBtn to be enabled so that once stopped the music can be played again
                playBtn.isEnabled = true
                //Set pauseBtn to be disables as once the music is stopped it cannot be paused
                pauseBtn.isEnabled = false
                //Set stopBtn to be disabled since the music is already stopped
                stopBtn.isEnabled = false


                //Toast message used to tell the user the music has stopped
                Toast.makeText(this,"music stopped",Toast.LENGTH_SHORT).show()
            }
        }
        // Seek bar change listener used to monitor if the user changes the position of the seek bar
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    //mediaPlayer seekTo to find a specified time position in the seek bar. i * 1000 because seekTo deals with milliseconds as
                    //standard and so has to be manually changed to seconds
                    mediaPlayer.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }
    // Method to initialize seek bar and show audio information
    private fun initialiseSeekBar() {
        //Sets the max amount of time on the seek bar for the audio being played
        seek_bar.max = mediaPlayer.seconds

        runnable = Runnable {
            //Sets the progress of the seek bar based on the position where the selector is on the seekbar based on currentSeconds
            seek_bar.progress = mediaPlayer.currentSeconds
            //Sets the label to show how many seconds have passed in the current audio
            time_pass.text = "${mediaPlayer.currentSeconds} sec"
            //Used to calculate the difference in time between how much the audio has played and the total time of audio
            val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
            //Sets the label to show how many seconds are left to be played of the audio
            time_left.text = "$diff sec"

            //Sets the runnable to run after 1000 milliseconds
            handler.postDelayed(runnable, 1000)
        }
        //Sets the runnable to be run after 1000 milliseconds
        handler.postDelayed(runnable, 1000)
    }
}
// Gets the mediaPlayer time duration in seconds
val MediaPlayer.seconds:Int
    get() {
        return this.duration / 1000
    }
//  Gets the mediaPlayer current position in seconds
val MediaPlayer.currentSeconds:Int
    get() {
        return this.currentPosition/1000
    }