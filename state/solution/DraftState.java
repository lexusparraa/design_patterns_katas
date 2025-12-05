package state.solution;

// 1. Estado Borrador (Draft)
// Comportamiento: Se puede editar. Al publicar, pasa a Moderación.
class DraftState implements State {
    private Document document;

    public DraftState(Document document) {
        this.document = document;
    }

    @Override
    public void addText(String text) {
        document.appendText(text);
        System.out.println("Text added. Current content: " + document.getText());
    }

    @Override
    public void publish() {
        // Transición: Draft -> Moderation
        document.changeState(new ModerationState(document));
        System.out.println("[Draft -> Moderation] Document sent for review.");
    }

    @Override
    public void reject() {
        System.out.println("It's already a draft.");
    }
}

// 2. Estado Moderación (Moderation)
// Comportamiento: Se puede editar (según reglas). Al publicar, pasa a Publicado. Al rechazar, vuelve a Draft.
class ModerationState implements State {
    private Document document;

    public ModerationState(Document document) {
        this.document = document;
    }

    @Override
    public void addText(String text) {
        // En moderación permitimos pequeños cambios antes de aprobar
        document.appendText(text);
        System.out.println("Text added. Current content: " + document.getText());
    }

    @Override
    public void publish() {
        // Transición: Moderation -> Published
        document.changeState(new PublishedState(document));
        System.out.println("[Moderation -> Published] Document approved and published.");
    }

    @Override
    public void reject() {
        // Transición: Moderation -> Draft
        document.changeState(new DraftState(document));
        System.out.println("Rejected. Moved back to Draft.");
    }
}

// 3. Estado Publicado (Published)
// Comportamiento: Bloqueado. No se puede editar ni rechazar.
class PublishedState implements State {
    private Document document;

    public PublishedState(Document document) {
        this.document = document;
    }

    @Override
    public void addText(String text) {
        System.out.println("Error: Cannot edit a published document.");
    }

    @Override
    public void publish() {
        System.out.println("Document is already published.");
    }

    @Override
    public void reject() {
        System.out.println("Error: Cannot reject a published document.");
    }
}