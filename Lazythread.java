package Assignmnt6;

public class Lazythread {
        private Resource resource = null;
        public Resource getResource() {
            if (resource == null)
                resource = new Resource();
            return resource;
        }
    }
}
