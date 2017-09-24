# frozen-smeagol

Frozen-Smeagol is essentially a single-page app which renders markdown files from a specified directory into a page framed with some common HTML. As such it may be useful to you and is certainly
something which you may want to adapt or incorporate into other projects; as such it is BSD licensed, rather than GPL which I normally use.

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein run

Markdown files are served from the directory `resources/public/content`.

## Licence

Copyright © 2017 Simon Brooke

Licence is BSD; see the LICENSE file.
