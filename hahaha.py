from flask import Flask, redirect, request
import spotipy
import spotipy.util as util
import sqlite3
from spotipy.oauth2 import SpotifyOAuth




client_id = 'bb4434d3f0d4442f853aa1790c985d22'
client_secret = '01691d959f344043b6e8bfac8e560fb8'
username = 'abc'
redirect_uri = 'https://google.com'

app = Flask(__name__)

@app.route('/login')
def login():
    # redirect user to Spotify's authorization page
    redirect_uri = 'http://localhost:8000/callback'
    scope = 'user-library-read'
    return redirect(util.prompt_for_user_token(username, scope, client_id=client_id, client_secret=client_secret, redirect_uri=redirect_uri))

@app.route('/callback')
def callback():
    # get the access token from the callback
    token = util.prompt_for_user_token(username, client_id=client_id, client_secret=client_secret, redirect_uri=redirect_uri)

    # create a Spotify client
    sp = spotipy.Spotify(auth_manager=SpotifyOAuth(client_id, client_secret, redirect_uri, username, token))

    # get the user's top n songs
    n = 10
    results = sp.current_user_top_tracks(time_range='long_term', limit=n)
    tracks = results['items']

    # connect to the SQL database
    conn = sqlite3.connect('spotify.db')
    c = conn.cursor()

    # create a table to store the data
    c.execute('''CREATE TABLE IF NOT EXISTS songs
                 (id text, name text, artist text, album text)''')

    # insert the data into the table
    for track in tracks:
        c.execute("INSERT INTO songs VALUES (?, ?, ?, ?)", (track['id'], track['name'], track['artists'][0]['name'], track['album']['name']))

    # commit the changes and close the connection
    conn.commit()
    conn.close()

    return 'Data stored in SQL database.'

if __name__ == '__main__':
    app.run(port=8000)

