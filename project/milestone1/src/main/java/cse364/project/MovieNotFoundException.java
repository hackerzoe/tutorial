package cse364.project;

class MovieNotFoundException extends RuntimeException {

    MovieNotFoundException(Long id) {
        super("Could not find Movie " + id);
    }
}